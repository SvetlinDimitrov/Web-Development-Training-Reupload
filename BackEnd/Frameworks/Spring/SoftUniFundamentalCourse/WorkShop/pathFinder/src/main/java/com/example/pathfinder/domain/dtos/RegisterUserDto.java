package com.example.pathfinder.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDto {

    private String username;
    private String fullName;
    private Integer age;
    private String password;
    private String email;
    private String confirmPassword;

}
