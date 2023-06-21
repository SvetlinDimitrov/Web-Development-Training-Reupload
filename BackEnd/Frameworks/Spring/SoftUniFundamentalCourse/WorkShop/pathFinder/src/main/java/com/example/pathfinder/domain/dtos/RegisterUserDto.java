package com.example.pathfinder.domain.dtos;

import com.example.pathfinder.exeptions.userEmail.EmailUniqueValidation;
import com.example.pathfinder.exeptions.userPasswords.PasswordTheSame;
import com.example.pathfinder.exeptions.userUsername.UsernameUniqueValidation;
import jakarta.validation.constraints.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@PasswordTheSame

public class RegisterUserDto {

    @NotBlank
    @UsernameUniqueValidation
    private String username;

    @Size(min = 3)
    @NotBlank
    @Size(min = 3)
    private String fullName;

    @NotNull
    @Positive
    private Integer age;

    @NotBlank
    @Size(min = 5 , max = 20)
    private String password;

    @NotBlank
    @EmailUniqueValidation
    @Email
    private String email;

    @NotBlank
    @Size(min = 5 , max = 20)
    private String confirmPassword;

}
