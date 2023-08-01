package com.example.demoschedualing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@Configuration
@EnableScheduling
public class ScheduleConfig {

    @Bean
    public Main getMain(){
        return new Main();
    }

    @Scheduled(fixedRate = 2000) // Execute every 2 seconds
    public void dummyMethod(){
        getMain().dummyPrint();
    }
}
