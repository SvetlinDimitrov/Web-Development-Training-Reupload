package com.example.pathfinder.config;

import com.example.pathfinder.domain.dtos.LoggedUserDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public ModelMapper mapper (){
        return new ModelMapper();
    }

    @Bean
    public LoggedUserDto loggedUser(){
        return new LoggedUserDto();
    }

}
