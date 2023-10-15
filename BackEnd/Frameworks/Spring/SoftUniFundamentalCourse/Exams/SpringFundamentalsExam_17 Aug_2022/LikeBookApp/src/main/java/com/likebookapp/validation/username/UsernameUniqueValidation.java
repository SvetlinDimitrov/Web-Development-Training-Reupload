package com.likebookapp.validation.username;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UsernameUniqueValidator.class)
public @interface UsernameUniqueValidation {
    String message() default "must be a unique username";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
