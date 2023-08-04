package com.example.pathfinder.domain.dtos;

import com.example.pathfinder.domain.constants.RoleConstant;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
public class LoginUserDto extends User {

    private Long id;

    private boolean isAdmin;

    public LoginUserDto(String username, String password, Set<RoleConstant> roleConstantSet , Long id) {
        super(username,
                password,
                roleConstantSet
                        .stream()
                        .map(r -> new SimpleGrantedAuthority(r.name()))
                        .collect(Collectors.toSet()));

        this.id = id;
        this.isAdmin = roleConstantSet
                .stream()
                .anyMatch(r->r.equals(RoleConstant.ADMIN));
    }
}
