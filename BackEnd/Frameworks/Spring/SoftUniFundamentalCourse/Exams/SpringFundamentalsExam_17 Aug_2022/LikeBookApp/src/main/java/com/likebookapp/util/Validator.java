package com.likebookapp.util;

import com.likebookapp.model.dtos.UserRegisterDto;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.function.BiConsumer;

public class Validator {

    public static BiConsumer<UserRegisterDto, BindingResult> checkPasswordsEquality
            = (user, result) -> {
        if (user.getPassword() == null || user.getConfirmPassword() == null ||
                user.getPassword().isBlank() || user.getConfirmPassword().isBlank() ||
                !user.getPassword().equals(user.getConfirmPassword())) {
            result.addError(new FieldError("registerDto", "confirmPassword", "passwordsMustMatch"));
        }
    };
}
