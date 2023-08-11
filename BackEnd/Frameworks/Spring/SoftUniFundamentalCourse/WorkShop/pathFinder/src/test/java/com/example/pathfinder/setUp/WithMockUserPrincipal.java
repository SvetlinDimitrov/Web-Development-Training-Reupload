package com.example.pathfinder.setUp;

import com.example.pathfinder.domain.constants.RoleConstant;
import com.example.pathfinder.domain.dtos.LoginUserDto;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContext;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

// Custom annotation to simulate @AuthenticationPrincipal
@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockUserSecurityContextFactory.class)
public @interface WithMockUserPrincipal {
    String username() default "user";
    String id() default "1";
    RoleConstant[] roles() default RoleConstant.USER;
}

class WithMockUserSecurityContextFactory implements WithSecurityContextFactory<WithMockUserPrincipal> {
    @Override
    public SecurityContext createSecurityContext(WithMockUserPrincipal annotation) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();

        LoginUserDto loginUserDto = new LoginUserDto(annotation.username() ,
                "password" ,
                Arrays.stream(annotation.roles()).collect(Collectors.toSet()),
                Long.parseLong(annotation.id()));


        Authentication auth = new UsernamePasswordAuthenticationToken(loginUserDto, "password", loginUserDto.getAuthorities());
        context.setAuthentication(auth);

        return context;
    }
}