package com.example.mobileleweb.domain.viewDtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class LoginUserDto {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
