package com.plannerapp.model.dtos;

import com.plannerapp.model.entity.UserEntity;
import com.plannerapp.vallidation.UniqueEmail.UniqueEmailConstraint;
import com.plannerapp.vallidation.UniqueUsername.UniqueUsernameConstraint;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserRegisterDto {

    @Length(min = 3 , max = 20)
    @NotBlank
    @UniqueUsernameConstraint
    private String username;

    @NotBlank
    @Length(min = 3 , max = 20)
    private String password;

    @NotBlank
    @Length(min = 3 , max = 20)
    private String confirmPassword;

    @Email
    @NotBlank
    @UniqueEmailConstraint
    private String email;

    public UserEntity toUser (){
        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}
