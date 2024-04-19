package org.trackerwebapp.customauthdemo.config.security.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.trackerwebapp.customauthdemo.config.security.auth.CustomAuthentication;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

  @Value("${our.very.very.very.secret.key}")
  private String key;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    CustomAuthentication ca = (CustomAuthentication) authentication;

    String headerKey = ca.getKey();

    if (key.equals(headerKey)) {
      return new CustomAuthentication(true, null);
    }

    throw new BadCredentialsException("Oh No!");
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return CustomAuthentication.class.equals(authentication);
  }
}
