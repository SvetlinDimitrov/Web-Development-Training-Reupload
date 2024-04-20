package org.demo.multiple_auth_providers.config.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.demo.multiple_auth_providers.config.authentication.ApiKeyAuthentication;
import org.demo.multiple_auth_providers.config.manager.CustomAuthManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class CustomAuthFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    var requestKey = request.getHeader("x-api-key");

    CustomAuthManager manager = new CustomAuthManager();

    if (requestKey == null || "null".equals(requestKey)) {
      filterChain.doFilter(request, response);
    }

    ApiKeyAuthentication auth = new ApiKeyAuthentication(requestKey);

    try {
      var a = manager.authenticate(auth);
      if (a.isAuthenticated()) {
        SecurityContextHolder.getContext().setAuthentication(a);
        filterChain.doFilter(request, response);
      } else {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      }
    } catch (AuthenticationException e) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }

  }
}
