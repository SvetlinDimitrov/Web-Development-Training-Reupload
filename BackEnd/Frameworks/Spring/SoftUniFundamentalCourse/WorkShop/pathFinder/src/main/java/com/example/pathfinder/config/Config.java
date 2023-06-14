package com.example.pathfinder.config;

import com.example.pathfinder.domain.dtos.LoggedUserDto;
import com.example.pathfinder.domain.dtos.RegisterUserDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    @Bean
    public ModelMapper mapper (){
        return new ModelMapper();
    }

    @Bean
    @Scope("singleton")
    public LoggedUserDto loggedUser(){
        return new LoggedUserDto();
    }

}
