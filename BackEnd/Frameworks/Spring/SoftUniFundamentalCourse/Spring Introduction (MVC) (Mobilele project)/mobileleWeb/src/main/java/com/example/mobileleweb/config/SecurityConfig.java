package com.example.mobileleweb.config;

import com.example.mobileleweb.domain.constants.Role;
import com.example.mobileleweb.repo.UserRepository;
import com.example.mobileleweb.service.security.UserDetailsServiceImp;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                        (request) -> request.
                                requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().
                                requestMatchers("/users/login", "users/register").anonymous().
                                requestMatchers("/brands/all").hasRole(Role.Admin.name()).
                                anyRequest().
                                authenticated()
                )
                .formLogin((formLogin) ->
                        formLogin
                                .loginPage("/users/login")
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .failureUrl("/users/login?error=true")
                                .successForwardUrl("/")
                                .permitAll()

                )
                .logout((out) ->
                        out.
                                logoutUrl("/users/logout").
                                logoutSuccessUrl("/users/login").
                                clearAuthentication(true))
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder("secret",2,2, Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA1);
    }

    @Bean
    public UserDetailsService getService(UserRepository userRepository) {
        return new UserDetailsServiceImp(userRepository);
    }
}
