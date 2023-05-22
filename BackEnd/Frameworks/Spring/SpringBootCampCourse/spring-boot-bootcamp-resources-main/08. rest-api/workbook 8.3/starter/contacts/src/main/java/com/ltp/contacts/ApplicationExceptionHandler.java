package com.ltp.contacts;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ltp.contacts.exception.ContactNotFoundException;
import com.ltp.contacts.exception.ErrorResponse;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class ApplicationExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<Object> handleContactNotFoundException(ContactNotFoundException ex) {
      ErrorResponse error = new ErrorResponse(Arrays.asList(ex.getLocalizedMessage()));
      return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        for (ObjectError error : allErrors) {
            System.out.println(error.getDefaultMessage());
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
