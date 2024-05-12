package com.example.demo.service;

import com.example.demo.dto.UsersRequestDto;
import com.example.demo.dto.UsersResponseDto;
import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.apache.coyote.Request;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public List<UsersResponseDto> getAll() {
        return usersRepository.findAll().stream().map(
                users -> UsersResponseDto.builder()
                        .firstName(users.getFirstName())
                        .lastName(users.getLastName())
                        .patronymicName(users.getPatronymicName())
                        .login(users.getLogin())
                        .password(users.getPassword())
                        .age(users.getAge())
                        .build()
        ).collect(Collectors.toList());
    }

    public Users getUserById(int id) {
        return usersRepository.findUsersById(id);
    }

    public Users deleteUsersById(int id) {
        return usersRepository.deleteById(id);
    }


    public void addNewUser(UsersRequestDto usersRequestDto) {
        Users insertUser = Users.builder()
                .firstName(usersRequestDto.getFirstName())
                .lastName(usersRequestDto.getLastName())
                .patronymicName(usersRequestDto.getPatronymicName())
                .login(usersRequestDto.getLogin())
                .password(usersRequestDto.getPassword())
                .age(usersRequestDto.getAge())
                .build();
        usersRepository.save(insertUser);
    }

    public Users updateUser(int id, UsersRequestDto usersRequestDto) {
        Users existingUser = usersRepository.findUsersById(id);

        if (existingUser != null) {
            existingUser.setFirstName(usersRequestDto.getFirstName());
            existingUser.setLastName(usersRequestDto.getLastName());
            existingUser.setPatronymicName(usersRequestDto.getPatronymicName());
            existingUser.setLogin(usersRequestDto.getLogin());
            existingUser.setPassword(usersRequestDto.getPassword());
            existingUser.setAge(usersRequestDto.getAge());
            return usersRepository.save(existingUser);
        } else {
            System.out.println("Ид не найден");
        }

        return existingUser;
    }
    public List<UsersResponseDto> testGet() {
        return usersRepository.getAll().stream().map(
                users -> UsersResponseDto.builder()
                        .firstName(users.getFirstName())
                        .lastName(users.getLastName())
                        .patronymicName(users.getPatronymicName())
                        .login(users.getLogin())
                        .password(users.getPassword())
                        .age(users.getAge())
                        .build()
        ).collect(Collectors.toList());
    }
}