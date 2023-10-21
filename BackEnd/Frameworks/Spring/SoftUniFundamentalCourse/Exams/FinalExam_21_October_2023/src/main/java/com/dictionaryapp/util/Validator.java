package com.dictionaryapp.util;

import com.dictionaryapp.model.dtos.UserRegisterDto;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.function.BiConsumer;

public class Validator {

    public static BiConsumer<UserRegisterDto, BindingResult> checkPasswordsEquality
            = (user, result) -> {
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            result.addError(new FieldError("userRegisterDto", "confirmPassword", "Passwords must match!"));
        }
    };
}
