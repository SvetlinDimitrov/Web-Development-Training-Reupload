package com.example.spring_mapper_exercise.domain.DTOs;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.example.spring_mapper_exercise.domain.enums.CONSTANTS.*;

@Getter
@NoArgsConstructor
public class UserRegisterDto {
    private String email ;
    private String password;
    private String fullName;

    public UserRegisterDto(String email, String password, String confirmPassword, String fullName) {
        setEmail(email);
        setPassword(password , confirmPassword);
        setFullName(fullName);
    }

    public void setEmail(String email) {

        if(email.matches(EMAIL_VALIDATOR_REGEX)){
            this.email = email;
            return;
        }
        throw new IllegalArgumentException(EMAIL_WRONG_MESSAGE);
    }

    public void setPassword(String password, String confirmPassword) {
        boolean equalsPassword = password.equals(confirmPassword);
        boolean validPassword = password.matches(PASSWORD_VALIDATOR_REGEX);
        if(equalsPassword && validPassword){
            this.password = password;
            return;
        }
        throw new IllegalArgumentException(PASSWORD_NAME_WRONG);
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
