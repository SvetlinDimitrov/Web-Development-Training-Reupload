package com.example.mobilelegraderebuild.service.User;

import com.example.mobilelegraderebuild.domain.entity.UserEntity;
import com.example.mobilelegraderebuild.domain.entity.UserRole;
import com.example.mobilelegraderebuild.domain.viewDtos.RegisterUserDto;
import com.example.mobilelegraderebuild.domain.viewDtos.SecurityViewUser;
import com.example.mobilelegraderebuild.repo.UserRepository;
import com.example.mobilelegraderebuild.service.UserRole.UserRoleService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Component
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserRoleService userRoleService;
    private PasswordEncoder passwordEncoder;
    private SecurityContextRepository securityContextRepository;

    @Override
    public void register(RegisterUserDto registerUserDto, HttpServletRequest request, HttpServletResponse response) {

        UserEntity userEntity = new UserEntity(registerUserDto);
        userEntity.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        UserRole role = userRoleService.findByRole(registerUserDto.getRole());
        userEntity.setRole(role);
        userRepository.save(userEntity);

        SecurityViewUser user = new SecurityViewUser(userEntity);

        Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());

        SecurityContextHolderStrategy holderStrategy = SecurityContextHolder.getContextHolderStrategy();

        SecurityContext context = holderStrategy.createEmptyContext();
        context.setAuthentication(authentication);

        holderStrategy.setContext(context);

        securityContextRepository.saveContext(context, request, response);

    }


    @Override
    public boolean checkIfUsernameAlreadyExists(String username) {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        return user.isEmpty();
    }


    @Override
    public UserEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public UserEntity findById(String id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }


}
