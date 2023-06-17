package com.example.validationexercise.exeptions.companyNameValidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CompanyNameValidator.class)
public @interface CompanyNameConstant {
    String message() default "this name is already in used";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
