package com.example.battleships.exeptions.userConstraint.uniqueName;

import com.example.battleships.service.user.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UniqueNameUser implements ConstraintValidator<UserConstraintName , String> {

    private UserService userService;

    @Override
    public void initialize(UserConstraintName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return userService.isNotPresentUsername(name);
    }
}
