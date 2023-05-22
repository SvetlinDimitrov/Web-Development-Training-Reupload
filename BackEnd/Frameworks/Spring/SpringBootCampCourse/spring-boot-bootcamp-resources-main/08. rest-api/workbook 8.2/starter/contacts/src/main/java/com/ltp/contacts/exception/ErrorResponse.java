package com.ltp.contacts.exception;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ErrorResponse {
    private String message;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ErrorResponse(String message) {
        this.message = message;
        date = LocalDate.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
