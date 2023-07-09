package org.example;

import org.example.validator.*;

public class Main {
    public static void main(String[] args) {
        RegisterValidation registerValidation =
                new EmailValidator(
                        new AgeValidator(
                                new PasswordValidator(
                                        new NameValidator(null))));


        User user = new User("kotak", 18, "sss", "sss", "kotka@abv.bg");
        boolean validate = registerValidation.validate(user);
        System.out.println(validate);


    }
}