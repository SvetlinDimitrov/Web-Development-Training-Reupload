package com.example.pathfinder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(httpRequest -> {
                    httpRequest
                            .requestMatchers("/users/login", "/users/register" , "/").permitAll()
                            .anyRequest().authenticated();
                })
                .formLogin(login -> {
                    login
                            .usernameParameter("username")
                            .passwordParameter("password")
                            .loginPage("/users/login")
                            .failureUrl("/users/login?error=true")
                            .defaultSuccessUrl("/", true);
                })
                .logout((logout) ->
                        logout.clearAuthentication(true)
                                .logoutUrl("/users/loggout"))
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
