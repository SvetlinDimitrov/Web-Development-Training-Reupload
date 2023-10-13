package com.resellerapp.model.dtos;
import com.resellerapp.model.entity.User;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class RegisterUserDto {

    @NotBlank
    @Length(min = 3, max = 20)
    private String username;

    @NotBlank
    @Length(min = 3, max = 20)
    private String password;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String confirmPassword;

    public User toUser(){
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

}
