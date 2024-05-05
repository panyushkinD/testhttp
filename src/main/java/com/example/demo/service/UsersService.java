package com.example.demo.service;

import com.example.demo.dto.UsersResponseDto;
import com.example.demo.repository.UsersRepository;
import lombok.AllArgsConstructor;
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
}
