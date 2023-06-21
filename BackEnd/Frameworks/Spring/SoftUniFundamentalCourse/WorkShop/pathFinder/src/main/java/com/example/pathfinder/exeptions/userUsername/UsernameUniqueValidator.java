package com.example.pathfinder.exeptions.userUsername;

import com.example.pathfinder.service.user.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsernameUniqueValidator implements ConstraintValidator<UsernameUniqueValidation , String> {

    private UserService userService;

    @Override
    public void initialize(UsernameUniqueValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return userService.checkTheUsername(value);
    }
}
