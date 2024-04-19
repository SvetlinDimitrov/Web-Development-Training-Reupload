package org.trackerwebapp.customauthdemo.config.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.trackerwebapp.customauthdemo.config.security.filter.CustomAuthFilter;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

  private final CustomAuthFilter customAuthenticationFilter;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .addFilterAt(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        .authorizeHttpRequests(request -> request.anyRequest().authenticated())
        .build();
  }
}
