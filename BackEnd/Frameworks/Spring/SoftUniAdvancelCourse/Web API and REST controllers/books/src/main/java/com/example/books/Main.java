package com.example.books;

import com.example.books.service.SeedService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Main {
    private SeedService service;
    @PostConstruct
    public void seedAll(){
        service.seedAll();
    }
}
