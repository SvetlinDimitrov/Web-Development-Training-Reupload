package com.example.pathfinder.exeptions.userEmail;

import com.example.pathfinder.service.user.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmailUniqueValidator implements ConstraintValidator<EmailUniqueValidation , String> {

    private UserService userService;

    @Override
    public void initialize(EmailUniqueValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return userService.checkTheEmail(value);
    }
}
