package com.example.demo.controller;

import com.example.demo.dto.UsersResponseDto;
import com.example.demo.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RequestMapping("/api/v1/main")
public class UsersController{
    private final UsersService usersService;

    @GetMapping(value = "/all-users")
    public List <UsersResponseDto> getAllUsers () {
        return usersService.getAll();
    }

}
