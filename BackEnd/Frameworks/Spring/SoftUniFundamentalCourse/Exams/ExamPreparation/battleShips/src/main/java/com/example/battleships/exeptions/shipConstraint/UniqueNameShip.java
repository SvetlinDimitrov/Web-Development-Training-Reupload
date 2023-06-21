package com.example.battleships.exeptions.shipConstraint;

import com.example.battleships.service.ship.ShipService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UniqueNameShip implements ConstraintValidator<ShipConstraintName , String> {

    private ShipService service;

    @Override
    public void initialize(ShipConstraintName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return service.isNotPresent(name);
    }
}
