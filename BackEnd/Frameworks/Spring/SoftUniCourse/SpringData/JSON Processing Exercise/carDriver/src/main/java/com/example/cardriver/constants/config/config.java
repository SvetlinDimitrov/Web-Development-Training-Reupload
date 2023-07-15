package com.example.cardriver.constants.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class config {

    @Bean
    public Gson gson(){
        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }
}
