package com.example.demoschedualing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class DemoSchedulingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSchedulingApplication.class, args);
	}

}
