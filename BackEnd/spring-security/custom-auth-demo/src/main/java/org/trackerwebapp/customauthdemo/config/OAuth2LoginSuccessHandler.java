package org.trackerwebapp.customauthdemo.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.trackerwebapp.customauthdemo.UserEntity;
import org.trackerwebapp.customauthdemo.UserServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class OAuth2LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

  private final UserServiceImpl userService;

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

    OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
    if ("github".equals(oAuth2AuthenticationToken.getAuthorizedClientRegistrationId())) {
      DefaultOAuth2User principal = (DefaultOAuth2User) authentication.getPrincipal();
      Map<String, Object> attributes = principal.getAttributes();
      String email = attributes.getOrDefault("email", "").toString();
      String name = attributes.getOrDefault("name", "").toString();
      userService.findByEmail(email)
          .ifPresentOrElse(user -> {
            DefaultOAuth2User newUser = new DefaultOAuth2User(List.of(new SimpleGrantedAuthority("USER")),
                attributes, "id");
            Authentication securityAuth = new OAuth2AuthenticationToken(newUser, List.of(new SimpleGrantedAuthority("USER")),
                oAuth2AuthenticationToken.getAuthorizedClientRegistrationId());
            SecurityContextHolder.getContext().setAuthentication(securityAuth);
          }, () -> {
            UserEntity userEntity = new UserEntity();
            userEntity.setEmail(email);
            userEntity.setName(name);
            userEntity.setSource("google");
            userService.save(userEntity);
            DefaultOAuth2User newUser = new DefaultOAuth2User(List.of(new SimpleGrantedAuthority("USER")),
                attributes, "id");
            Authentication securityAuth = new OAuth2AuthenticationToken(newUser, List.of(new SimpleGrantedAuthority("USER")),
                oAuth2AuthenticationToken.getAuthorizedClientRegistrationId());
            SecurityContextHolder.getContext().setAuthentication(securityAuth);
          });
    }
    this.setAlwaysUseDefaultTargetUrl(true);
    this.setDefaultTargetUrl("http://localhost:5173");
    super.onAuthenticationSuccess(request, response, authentication);
  }
}
