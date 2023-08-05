package com.example.pathfinder.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
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
    public Cloudinary cloudinaryConfig() {
       return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dgymtdwjt",
                "api_key", "884473836254984",
                "api_secret", "f6vFbpGjKrczkn3P94SJePDCNhw"));
    }

}
