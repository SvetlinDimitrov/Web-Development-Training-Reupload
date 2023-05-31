package com.example.supermarket;

import com.example.supermarket.domain.constants.ENUM;
import com.example.supermarket.domain.entity.Category;
import com.example.supermarket.service.category.CategoryService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.Scanner;
import java.util.Set;


@Component
@AllArgsConstructor
public class Main implements CommandLineRunner {

    private Scanner scanner;
    private CategoryService categoryService;

    @Override
    public void run(String... args) throws Exception {

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

        Validator validator = validatorFactory.getValidator();
        String input = "";
        ENUM.MENU_MAP.forEach((key, value) -> System.out.println(key + " - " + value));

        while(!input.equals("10")){
            input = scanner.nextLine();
            int command;
            try{
                command = Integer.parseInt(input);
            }catch (Exception e){
                System.out.println("Write a number in range of 1 to 10");
                continue;
            }
            String input2;
            switch (command){
                case 1:
                    System.out.println("Enter category name:");
                    input2 = scanner.nextLine();
                    Category category = new Category();
                    category.setName(input2);

                    Set<ConstraintViolation<Category>> validate = validator.validate(category);
                    if(validate.size() > 0){
                        validate.forEach(m -> System.out.println(m.getMessage()));
                    }
                    break;
                case 2:
            }
        }

    }
}
