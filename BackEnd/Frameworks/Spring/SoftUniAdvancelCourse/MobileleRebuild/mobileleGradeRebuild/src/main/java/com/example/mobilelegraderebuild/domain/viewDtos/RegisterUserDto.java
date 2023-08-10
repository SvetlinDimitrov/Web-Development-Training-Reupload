package com.example.mobilelegraderebuild.domain.viewDtos;
import com.example.mobilelegraderebuild.domain.constants.Role;
import com.example.mobilelegraderebuild.domain.exeptions.userUnieqName.UserUniqueName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




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

    public RegisterUserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public RegisterUserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public RegisterUserDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public RegisterUserDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public RegisterUserDto setRole(Role role) {
        this.role = role;
        return this;
    }
}
