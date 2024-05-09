package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersRequestDto {
    private String lastName;
    private String firstName;
    private String patronymicName;
    private String login;
    private String password;
    private int age;
//test
//test


}
