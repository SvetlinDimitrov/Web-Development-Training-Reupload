package com.example.football.util;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Validate {
    public static <T>boolean checkIfItsValid(T t){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(t).isEmpty();
    }
}