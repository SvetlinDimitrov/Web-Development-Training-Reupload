package org.demo.multiple_auth_providers.config.manager;

import org.demo.multiple_auth_providers.config.providers.ApiKeyProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthManager implements AuthenticationManager {

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    var provider = new ApiKeyProvider();

    if (provider.supports(authentication.getClass())) {
      return provider.authenticate(authentication);
    }

    return authentication;
  }

}
