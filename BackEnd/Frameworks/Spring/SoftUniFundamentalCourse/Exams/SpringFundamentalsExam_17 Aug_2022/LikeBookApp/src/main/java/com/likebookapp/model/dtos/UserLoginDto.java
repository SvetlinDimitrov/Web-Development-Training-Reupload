package com.likebookapp.model.dtos;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserLoginDto {

    @NotBlank
    @Length(min = 3 , max = 20)
    private String username;

    @NotBlank
    @Length(min = 3 , max = 20)
    private String password;

    @NotBlank
    @Email
    private String email;

}
