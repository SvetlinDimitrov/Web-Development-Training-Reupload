package com.plannerapp.model.dtos;

import com.plannerapp.vallidation.email.EmailUniqueValidation;
import com.plannerapp.vallidation.username.UsernameUniqueValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDto {

    @Size(min = 3 , max = 20)
    @UsernameUniqueValidation
    private String username;

    @Size(min = 3 , max = 20)
    private String password;
    @NotBlank
    private String confirmPassword;
    @NotBlank
    @Email
    @EmailUniqueValidation
    private String email;

}
