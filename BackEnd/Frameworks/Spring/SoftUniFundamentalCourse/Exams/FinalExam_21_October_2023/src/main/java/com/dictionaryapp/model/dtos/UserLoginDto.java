package com.dictionaryapp.model.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {

    @Size(min = 3 , max = 20 ,message = "Username length must be between 3 and 20 characters!")
    private String username;
    @Size(min = 3 , max = 20 ,message = "Password length must be between 3 and 20 characters!")
    private String password;

}
