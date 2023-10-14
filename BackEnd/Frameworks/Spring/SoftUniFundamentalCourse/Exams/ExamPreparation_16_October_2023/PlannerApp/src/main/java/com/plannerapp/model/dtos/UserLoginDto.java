package com.plannerapp.model.dtos;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class UserLoginDto {

    @Length(min = 3 , max = 20)
    @NotBlank
    private String username;

    @NotBlank
    @Length(min = 3 , max = 20)
    private String password;


}
