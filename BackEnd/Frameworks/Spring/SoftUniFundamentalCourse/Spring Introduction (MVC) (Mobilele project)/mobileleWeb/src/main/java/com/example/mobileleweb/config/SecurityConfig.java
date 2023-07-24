package com.example.mobileleweb.config;

import com.example.mobileleweb.domain.constants.Role;
import com.example.mobileleweb.repo.UserRepository;
import com.example.mobileleweb.service.security.UserDetailsServiceImp;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        (request) -> request.
                                requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().
                                requestMatchers("/users/login", "users/register").permitAll().
                                requestMatchers("/brands/all").hasRole(Role.Admin.name()).
                                anyRequest().
                                authenticated()
                )
                .formLogin((formLogin) ->
                        formLogin
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .loginPage("/users/login")
                                .failureUrl("/users/login")
                                .loginProcessingUrl("/users/login")
                )
                .logout((out) ->
                        out.
                                logoutUrl("/users/logout").
                                logoutSuccessUrl("/users/login").
                                clearAuthentication(true));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService getService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return new UserDetailsServiceImp(userRepository);
    }
}
