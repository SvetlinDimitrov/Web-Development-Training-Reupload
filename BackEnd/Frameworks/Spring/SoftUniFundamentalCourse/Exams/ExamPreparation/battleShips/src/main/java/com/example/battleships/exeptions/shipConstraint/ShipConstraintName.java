package com.example.battleships.exeptions.shipConstraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueNameShip.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ShipConstraintName {
    String message () default "";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
