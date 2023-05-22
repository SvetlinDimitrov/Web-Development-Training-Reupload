package com.example.spring_mapper_exercise.domain.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginDto {

    private String email;
    private String password;

    public UserLoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
