package com.example.cardealer;

import com.example.cardealer.service.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Controller implements CommandLineRunner {
    private SeedService seedService;

    @Autowired
    public Controller(SeedService seedService) {
        this.seedService = seedService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedService.seedAll();
    }
}
