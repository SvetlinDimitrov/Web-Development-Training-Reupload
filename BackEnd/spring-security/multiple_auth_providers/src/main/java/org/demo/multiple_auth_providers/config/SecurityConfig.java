package org.demo.multiple_auth_providers.config;

import lombok.RequiredArgsConstructor;
import org.demo.multiple_auth_providers.config.filter.CustomAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  private final CustomAuthFilter customAuthFilter;

  @Bean
  public SecurityFilterChain customSecurityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(requests -> requests.anyRequest().authenticated())
        .addFilterBefore(customAuthFilter, BasicAuthenticationFilter.class)
        .httpBasic(Customizer.withDefaults());
    return http.build();
  }
}
