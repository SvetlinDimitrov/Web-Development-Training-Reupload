package com.plannerapp.vallidation.UniqueEmail;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmailConstraint {
    String message() default "email must be unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}