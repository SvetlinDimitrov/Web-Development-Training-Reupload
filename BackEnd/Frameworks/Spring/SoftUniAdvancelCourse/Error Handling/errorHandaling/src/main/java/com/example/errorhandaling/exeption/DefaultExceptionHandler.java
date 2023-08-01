//package com.example.errorhandaling.exeption;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class DefaultExceptionHandler implements ErrorController {
//    private static final String ERROR_PATH = "/error";
//
//    @RequestMapping(ERROR_PATH)
//    public ResponseEntity<String> handleError(HttpServletResponse response) {
//        // Customize the error response based on the error status code
//        HttpStatus status = getErrorStatus(response);
//        String errorMessage = "Oops! Something went wrong. Please try again later.";
//
//        if (status.is4xxClientError()) {
//            errorMessage = "Client error occurred. Please check your request.";
//        } else if (status.is5xxServerError()) {
//            errorMessage = "Server error occurred. Our team has been notified.";
//        }
//
//        return ResponseEntity.status(status).body(errorMessage);
//    }
//
//
//    public String getErrorPath() {
//        return ERROR_PATH;
//    }
//
//    private HttpStatus getErrorStatus(HttpServletResponse response) {
//        int status = response.getStatus();
//        return HttpStatus.valueOf(status);
//    }
//}
