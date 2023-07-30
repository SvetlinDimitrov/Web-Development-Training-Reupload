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
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http , SecurityContextRepository securityContextRepository) throws Exception {
        return http.authorizeHttpRequests(
                        (request) -> request.
                                requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().
                                requestMatchers("/users/login", "users/register").anonymous().
                                requestMatchers("/brands/all").hasRole(Role.ADMIN.name()).
                                anyRequest().
                                authenticated()
                )
                .formLogin((formLogin) ->
                        formLogin
                                .loginPage("/users/login")
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .failureUrl("/users/login?error=true")
                                .defaultSuccessUrl("/" , true)

                )
                .logout((out) ->
                        out.
                                logoutUrl("/users/logout").
                                logoutSuccessUrl("/users/login").
                                deleteCookies("JSESSIONID").
                                clearAuthentication(true)
                )
                .rememberMe((me) ->
                        me.
                                key("gospod").
                                tokenValiditySeconds(600000)

                        )
                .securityContext((sec) -> sec.securityContextRepository(securityContextRepository))
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

    @Bean
    public SecurityContextRepository getSecContext(){
        return new DelegatingSecurityContextRepository(
                new RequestAttributeSecurityContextRepository(),
                new HttpSessionSecurityContextRepository()
        );
    }
}
