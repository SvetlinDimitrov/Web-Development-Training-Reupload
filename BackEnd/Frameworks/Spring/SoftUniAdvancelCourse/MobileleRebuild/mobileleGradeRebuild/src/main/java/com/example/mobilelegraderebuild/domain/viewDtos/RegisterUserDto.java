package com.example.mobilelegraderebuild.domain.viewDtos;
import com.example.mobilelegraderebuild.domain.constants.Role;
import com.example.mobilelegraderebuild.domain.exeptions.userUnieqName.UserUniqueName;
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
