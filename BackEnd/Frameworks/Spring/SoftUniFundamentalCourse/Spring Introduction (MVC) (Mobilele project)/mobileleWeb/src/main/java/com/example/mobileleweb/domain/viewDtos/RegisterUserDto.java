package com.example.mobileleweb.domain.viewDtos;
import com.example.mobileleweb.domain.constants.Role;
import com.example.mobileleweb.domain.exeptions.userUnieqName.UserUniqueName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@NoArgsConstructor
@UserUniqueName
public class RegisterUserDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private Role role;

}
