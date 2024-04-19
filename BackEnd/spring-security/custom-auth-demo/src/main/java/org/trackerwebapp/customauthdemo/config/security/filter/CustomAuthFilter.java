package org.trackerwebapp.customauthdemo.config.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.trackerwebapp.customauthdemo.config.security.auth.CustomAuthentication;
import org.trackerwebapp.customauthdemo.config.security.managers.CustomAuthenticationManager;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class CustomAuthFilter extends OncePerRequestFilter {

  private final CustomAuthenticationManager customAuthenticationManager;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    // 1. create an authentication object which is not yet authenticated
    // 2. delegate the authentication object to the manager
    // 3. get back the authentication from the manager
    // 4. if the object is authenticated then send request to the next filter in the chain
    String key = String.valueOf(request.getHeader("key"));
    CustomAuthentication ca = new CustomAuthentication(false, key);

    var a = customAuthenticationManager.authenticate(ca);

    if (a.isAuthenticated()) {
      SecurityContextHolder.getContext().setAuthentication(a);
      filterChain.doFilter(request, response); // only when authentication worked
    }
  }
}
