package com.ltp.gradesubmission;

import com.ltp.gradesubmission.exception.CourseNotFoundException;
import com.ltp.gradesubmission.exception.ErrorResponse;
import com.ltp.gradesubmission.exception.GradeNotFoundException;
import com.ltp.gradesubmission.exception.StudentNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;


@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> list = ex.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        ErrorResponse errorResponse = new ErrorResponse(list);
        return new ResponseEntity<>(errorResponse , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CourseNotFoundException.class, GradeNotFoundException.class, StudentNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(RuntimeException ex){
        return new ResponseEntity<>(new ErrorResponse(List.of(ex.getMessage())), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleDataAccessException(EmptyResultDataAccessException ex) {
        return new ResponseEntity<>(new ErrorResponse(List.of("Cannot delete non-existing resource")), HttpStatus.NOT_FOUND);
    }



}
