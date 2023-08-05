package com.example.pathfinder.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
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
                            .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                            .requestMatchers("/",
                                    "/about",
                                    "/users/login",
                                    "/users/register",
                                    "/routes/**",
                                    "/comment/{routeId}").permitAll()
                            .requestMatchers("/users/admin").hasRole("ADMIN")
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
