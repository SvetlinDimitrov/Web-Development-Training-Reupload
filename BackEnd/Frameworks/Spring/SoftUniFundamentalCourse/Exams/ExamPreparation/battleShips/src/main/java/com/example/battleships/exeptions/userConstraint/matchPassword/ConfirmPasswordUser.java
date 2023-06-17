package com.example.battleships.exeptions.userConstraint.matchPassword;

import com.example.battleships.domain.bindingViews.ViewUser;
import com.example.battleships.service.user.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConfirmPasswordUser implements ConstraintValidator<UserConstraintConfirmPassword, ViewUser> {

    private UserService userService;


    @Override
    public void initialize(UserConstraintConfirmPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ViewUser user, ConstraintValidatorContext context) {
        return user.getPassword() != null &&
                user.getConfirmPassword() != null &&
                user.getConfirmPassword().equals(user.getPassword());
    }
}
