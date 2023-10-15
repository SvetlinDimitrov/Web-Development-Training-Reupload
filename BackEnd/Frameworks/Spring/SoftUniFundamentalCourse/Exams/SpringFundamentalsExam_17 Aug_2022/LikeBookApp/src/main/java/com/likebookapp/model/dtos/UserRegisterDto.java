package com.likebookapp.model.dtos;

import com.likebookapp.model.entity.UserEntity;
import com.likebookapp.validation.email.EmailUniqueValidation;
import com.likebookapp.validation.username.UsernameUniqueValidation;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserRegisterDto {
    @NotBlank
    @Length(min = 3 , max = 20)
    @UsernameUniqueValidation
    private String username;

    @NotBlank
    @Length(min = 3 , max = 20)
    private String password;

    @NotBlank
    private String confirmPassword;

    @NotBlank
    @Email
    @EmailUniqueValidation
    private String email;

    public UserEntity toUser(){
        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}
