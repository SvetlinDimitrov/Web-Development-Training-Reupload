package com.example.mobileleweb.service.User;

import com.example.mobileleweb.domain.constants.Role;
import com.example.mobileleweb.domain.entity.UserEntity;
import com.example.mobileleweb.domain.entity.UserRole;
import com.example.mobileleweb.domain.modelViewEntity.UserView;
import com.example.mobileleweb.domain.viewDtos.RegisterUserDto;
import com.example.mobileleweb.domain.viewDtos.ViewUser;
import com.example.mobileleweb.repo.UserRepository;
import com.example.mobileleweb.service.UserRole.UserRoleService;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserRoleService userRoleService;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;
    private SecurityContextRepository securityContextRepository;
    private UserDetailsService userDetailsService;

    @Override
    public void register(RegisterUserDto registerUserDto, HttpServletRequest request, HttpServletResponse response) {
        UserView view = modelMapper.map(registerUserDto, UserView.class);
        UserEntity userEntity = modelMapper.map(view, UserEntity.class);
        userEntity.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        UserRole role = userRoleService.findByRole(registerUserDto.getRole());
        userEntity.setRole(role);
        userRepository.save(userEntity);

        ViewUser user = new ViewUser(userEntity);

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
        return userRepository.findByUsername(username).get();
    }

    @Override
    public UserEntity findById(String sellerId) {
        return userRepository.findById(sellerId).get();
    }


    @PostConstruct
    public void init() {
        if (userRepository.findAll().isEmpty()) {
            userRepository.save(UserEntity.builder().username("user").password(passwordEncoder.encode("user")).firstName("user").lastName("user").isActive(true).role(userRoleService.findByRole(Role.USER)).build());
            userRepository.save(UserEntity.builder().username("admin").password(passwordEncoder.encode("admin")).firstName("admin").lastName("admin").isActive(true).role(userRoleService.findByRole(Role.ADMIN)).build());
        }
    }

}
