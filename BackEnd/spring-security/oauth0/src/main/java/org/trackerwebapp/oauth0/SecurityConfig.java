package org.trackerwebapp.oauth0;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Value("${oauth0.issuer}")
  private String issuer;

  @Value("${oauth0.audience}")
  private String audience;

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((authorize) -> authorize
            .requestMatchers("/api/public").permitAll()
            .requestMatchers("/api/private").authenticated()
        )
        .oauth2ResourceServer((oauth2) -> oauth2
            .jwt((jwt) -> jwt
                .decoder(jwtDecoder())
            )
        )
        .cors(Customizer.withDefaults())
        .csrf(AbstractHttpConfigurer::disable);

    return http.build();
  }

  //TODO:: NOT WORKING
  @Bean
  JwtDecoder jwtDecoder() {
    NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder)
        JwtDecoders.fromOidcIssuerLocation(issuer);

    OAuth2TokenValidator<Jwt> audienceValidator = new AudienceValidator(audience);
    OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);
    OAuth2TokenValidator<Jwt> withAudience = new DelegatingOAuth2TokenValidator<>(withIssuer, audienceValidator);

    jwtDecoder.setJwtValidator(withAudience);

    return jwtDecoder;
  }
}