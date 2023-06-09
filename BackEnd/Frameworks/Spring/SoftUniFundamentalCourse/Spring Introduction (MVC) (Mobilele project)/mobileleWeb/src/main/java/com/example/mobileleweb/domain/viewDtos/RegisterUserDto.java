package com.example.mobileleweb.domain.viewDtos;
import com.example.mobileleweb.domain.constants.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@NoArgsConstructor
public class RegisterUserDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;
}
