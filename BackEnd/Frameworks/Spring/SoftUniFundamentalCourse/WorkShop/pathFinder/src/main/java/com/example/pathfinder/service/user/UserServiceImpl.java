package com.example.pathfinder.service.user;

import com.example.pathfinder.domain.bindingViews.ViewComments;
import com.example.pathfinder.domain.bindingViews.ViewRoles;
import com.example.pathfinder.domain.bindingViews.ViewRoute;
import com.example.pathfinder.domain.bindingViews.ViewUser;
import com.example.pathfinder.domain.constants.Level;
import com.example.pathfinder.domain.dtos.LoginUserDto;
import com.example.pathfinder.domain.dtos.RegisterUserDto;
import com.example.pathfinder.domain.entity.Role;
import com.example.pathfinder.domain.entity.UserEntity;
import com.example.pathfinder.repos.UserRepository;
import com.example.pathfinder.service.role.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(RegisterUserDto registerUserDto) {

        UserEntity userView = toUserEntity(registerUserDto);
        userRepository.save(userView);
    }


    @Override
    public boolean checkTheEmail(String value) {
        return userRepository.findByEmail(value).isEmpty();
    }

    @Override
    public boolean checkTheUsername(String value) {
        return userRepository.findByUsername(value).isEmpty();
    }

    @Override
    @Transactional
    public ViewUser getViewUserById(Long id) {
        return toViewUser(findById(id));
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public LoginUserDto findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(this::toLoginUserDto)
                .orElseThrow(() -> new RuntimeException("No user have that username"));

    }

    private LoginUserDto toLoginUserDto(UserEntity userEntity) {
        return new LoginUserDto(userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getRoles()
                        .stream()
                        .map(Role::getRole)
                        .collect(Collectors.toSet()),
                userEntity.getId());
    }

    private UserEntity toUserEntity(RegisterUserDto dto) {
        return UserEntity.builder()
                .username(dto.getUsername())
                .fullName(dto.getFullName())
                .age(dto.getAge())
                .password(passwordEncoder.encode(dto.getPassword()))
                .email(dto.getEmail())
                .level(Level.BEGINNER)
                .roles(roleService.getRegisterRoles())
                .build();
    }

    private ViewUser toViewUser(UserEntity user) {
        return new ViewUser(user);
    }

}
