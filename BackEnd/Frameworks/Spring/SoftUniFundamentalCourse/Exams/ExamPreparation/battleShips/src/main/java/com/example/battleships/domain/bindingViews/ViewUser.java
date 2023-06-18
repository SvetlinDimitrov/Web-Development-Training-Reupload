package com.example.battleships.domain.bindingViews;

import com.example.battleships.domain.entity.User;
import com.example.battleships.exeptions.userConstraint.matchPassword.UserConstraintConfirmPassword;
import com.example.battleships.exeptions.userConstraint.uniqueEmail.UserConstraintEmail;
import com.example.battleships.exeptions.userConstraint.uniqueName.UserConstraintName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@UserConstraintConfirmPassword
public class ViewUser {

    private Long id;

    @Size(min = 3 , max = 10)
    @NotEmpty
    @UserConstraintName
    private String username;

    @Size(min = 5 , max = 20)
    @NotEmpty
    private String fullName;

    @Size(min = 3)
    @NotEmpty
    private String password;

    @UserConstraintEmail
    @Email
    @NotEmpty
    private String email;



    private String confirmPassword;

    public User toUser(){
        return User.builder()
                .email(email)
                .fullName(fullName)
                .username(username)
                .password(password)
                .build();
    }
}
