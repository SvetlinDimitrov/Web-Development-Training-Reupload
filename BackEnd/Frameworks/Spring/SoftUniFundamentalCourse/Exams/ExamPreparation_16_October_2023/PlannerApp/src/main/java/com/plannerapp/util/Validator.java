package com.plannerapp.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class Validator {

    public static void checkPasswords(String password , String confirmPassword , BindingResult result){
        if(!password.equals(confirmPassword)){
            result.addError(new FieldError("registerDto" , "confirmPassword" , "passwords should match !!!"));
        }
    }
}
