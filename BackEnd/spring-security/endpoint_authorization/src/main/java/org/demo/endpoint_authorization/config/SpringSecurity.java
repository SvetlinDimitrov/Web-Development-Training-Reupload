package org.demo.endpoint_authorization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurity {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .authorizeHttpRequests(
            requests -> requests
                .anyRequest().authenticated()  // endpoint level authorization  // find ANT expressions  /**
//        .anyRequest().permitAll()
//        .anyRequest().denyAll()
//        .anyRequest().hasAuthority("read")
//        .anyRequest().hasAnyAuthority("read", "write")
//        .anyRequest().hasRole("ADMIN")
//        .anyRequest().hasAnyRole("ADMIN", "MANAGER")
//        .anyRequest().access("isAuthenticated() and hasAuthority('read')")  // SpEL  --> authorization rules

        )
        .httpBasic(Customizer.withDefaults())
        .build();
  }
  // matcher method + authorization rule
  // 1. which matcher methods should you use and how  ( anyRequest(), mvcMatchers(), antMatchers(), regexMatchers() )
  // 2. how to apply different authorization rules

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    InMemoryUserDetailsManager detailsManager = new InMemoryUserDetailsManager();

    var u1 = User.withUsername("user")
        .password(passwordEncoder().encode("12345"))
//        .roles("ADMIN")  // equivalent with and authority named ROLE_ADMIN
        .authorities("read")
        .build();

    var u2 = User.withUsername("user1")
        .password(passwordEncoder().encode("12345"))
//        .roles("MANAGER")
        .authorities("write")
        .build();

    detailsManager.createUser(u1);
    detailsManager.createUser(u2);

    return detailsManager;
  }
}
