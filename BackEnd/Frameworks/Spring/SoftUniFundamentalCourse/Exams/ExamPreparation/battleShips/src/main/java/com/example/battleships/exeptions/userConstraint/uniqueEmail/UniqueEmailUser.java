package com.example.battleships.exeptions.userConstraint.uniqueEmail;

import com.example.battleships.service.user.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UniqueEmailUser implements ConstraintValidator<UserConstraintEmail, String> {

    private UserService userService;

    @Override
    public void initialize(UserConstraintEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return userService.isNotPresentEmail(name);
    }
}
