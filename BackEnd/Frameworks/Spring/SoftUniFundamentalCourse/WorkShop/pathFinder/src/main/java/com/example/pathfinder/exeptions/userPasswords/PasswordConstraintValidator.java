package com.example.pathfinder.exeptions.userPasswords;


import com.example.pathfinder.domain.dtos.RegisterUserDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<PasswordTheSame , RegisterUserDto> {
    @Override
    public void initialize(PasswordTheSame constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(RegisterUserDto user, ConstraintValidatorContext context) {
        return user.getPassword() != null &&
                user.getConfirmPassword() != null &&
                user.getPassword().equals(user.getConfirmPassword());
    }
}
