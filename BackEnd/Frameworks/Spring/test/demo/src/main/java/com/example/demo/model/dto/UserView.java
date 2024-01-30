package com.example.demo.model.dto;

import java.time.LocalDate;

public record UserView(String id, String name, String password , LocalDate date) {
}
