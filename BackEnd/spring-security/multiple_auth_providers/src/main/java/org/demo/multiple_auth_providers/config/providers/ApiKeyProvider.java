package org.demo.multiple_auth_providers.config.providers;

import org.demo.multiple_auth_providers.config.authentication.ApiKeyAuthentication;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class ApiKeyProvider implements AuthenticationProvider {

  private static final String key = "secret";

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    ApiKeyAuthentication auth = (ApiKeyAuthentication) authentication;
    if (key.equals(auth.getApiKey())) {
      auth.setAuthenticated(true);
      return auth;
    }
    throw new BadCredentialsException(":(");
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return ApiKeyAuthentication.class.equals(authentication);
  }
}