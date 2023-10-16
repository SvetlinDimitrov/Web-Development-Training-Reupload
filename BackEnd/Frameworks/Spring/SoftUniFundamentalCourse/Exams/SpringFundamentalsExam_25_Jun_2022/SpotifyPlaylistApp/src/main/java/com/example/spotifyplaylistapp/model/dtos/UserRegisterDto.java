package com.example.spotifyplaylistapp.model.dtos;


import com.example.spotifyplaylistapp.model.entity.UserEntity;
import com.example.spotifyplaylistapp.validations.email.UniqueEmailConstant;
import com.example.spotifyplaylistapp.validations.username.UniqueUsernameConstant;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserRegisterDto {

    @NotBlank
    @Length(min = 3 , max = 20)
    @UniqueUsernameConstant
    private String username;
    @NotBlank
    @Length(min = 3 , max = 20)
    private String password;
    @NotBlank
    @Length(min = 3 , max = 20)
    private String confirmPassword;
    @NotBlank
    @Email
    @UniqueEmailConstant
    private String email;

    public UserEntity toUserEntity(){
        UserEntity user = new UserEntity();
        user.setPassword(password);
        user.setEmail(email);
        user.setUsername(username);
        return user;
    }
}
