package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//if we had MYSQL Driver this is a simple way to configuration

public class DataSourceConfig {

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("12345");
        dataSource.setUrl(
                "jdbc:mysql://localhost:3306/myDb?createDatabaseIfNotExist=true");

        return dataSource;
    }
}
