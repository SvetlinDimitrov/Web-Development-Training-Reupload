package com.dictionaryapp.model.dtos;

import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.validation.email.EmailUniqueValidation;
import com.dictionaryapp.validation.username.UsernameUniqueValidation;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDto {


    @UsernameUniqueValidation(message = "Username is already in used")
    @Size(min = 3 , max = 20 , message = "Username length must be between 3 and 20 characters!" )
    private String username;

    @Size(min = 3 , max = 20 , message = "Password length must be between 3 and 20 characters!")
    private String password;

    @EmailUniqueValidation(message = "Email is already in used")
    @Email(message = "Email must be valid")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    private String confirmPassword;

    public User toUser(){
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }

}
