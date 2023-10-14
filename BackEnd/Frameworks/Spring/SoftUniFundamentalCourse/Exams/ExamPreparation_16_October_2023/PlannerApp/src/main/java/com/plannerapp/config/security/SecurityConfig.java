package com.plannerapp.config.security;

;
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
                            .antMatchers("/").permitAll()
                            .antMatchers("/user/login", "/user/register").hasRole("ANONYMOUS")
                            .anyRequest().authenticated();
                })
                .formLogin(login -> {
                    login
                            .usernameParameter("username")
                            .passwordParameter("password")
                            .loginPage("/user/login")
                            .failureUrl("/user/login?error=true")
                            .defaultSuccessUrl("/", true);
                })
                .logout((logout) ->
                        logout.clearAuthentication(true)
                                .logoutUrl("/user/logout"))
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

