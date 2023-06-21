package com.example.validationexercise.exeptions.companyNameValidation;

import com.example.validationexercise.service.CompanyService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CompanyNameValidator implements ConstraintValidator<CompanyNameConstant , String> {

    private CompanyService service;

    @Override
    public void initialize(CompanyNameConstant constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String companyName, ConstraintValidatorContext context) {
        return !service.isAlreadyExists(companyName);
    }
}
