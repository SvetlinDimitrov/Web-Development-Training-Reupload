package com.example.errorhandaling.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR , reason = "nz brat")
public class CustomException extends RuntimeException {
    public CustomException() {
        super("Error");
    }
}
