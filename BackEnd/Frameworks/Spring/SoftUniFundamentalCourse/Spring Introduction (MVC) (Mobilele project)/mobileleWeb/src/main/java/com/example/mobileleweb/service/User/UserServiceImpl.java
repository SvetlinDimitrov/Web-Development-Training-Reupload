package com.example.mobileleweb.service.User;

import com.example.mobileleweb.domain.constants.Role;
import com.example.mobileleweb.domain.entity.UserEntity;
import com.example.mobileleweb.domain.entity.UserRole;
import com.example.mobileleweb.domain.modelViewEntity.UserView;
import com.example.mobileleweb.domain.viewDtos.RegisterUserDto;
import com.example.mobileleweb.repo.UserRepository;
import com.example.mobileleweb.service.UserRole.UserRoleService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserRoleService userRoleService;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;
    @Override
    public void register(RegisterUserDto registerUserDto) {
        UserView view = modelMapper.map(registerUserDto, UserView.class);
        UserEntity userEntity = modelMapper.map(view, UserEntity.class);
        userEntity.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        UserRole role = userRoleService.findByRole(registerUserDto.getRole());
        userEntity.setRole(role);
        userRepository.save(userEntity);
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
    public void init(){
        if(userRepository.findAll().isEmpty()){
            userRepository.save(
                    UserEntity.builder()
                            .username("user")
                            .password(passwordEncoder.encode("user"))
                            .firstName("user")
                            .lastName("user")
                            .isActive(true)
                            .role(userRoleService.findByRole(Role.User))
                            .build()
            );
            userRepository.save(
                    UserEntity.builder()
                            .username("admin")
                            .password(passwordEncoder.encode("admin"))
                            .firstName("admin")
                            .lastName("admin")
                            .isActive(true)
                            .role(userRoleService.findByRole(Role.Admin))
                            .build()
            );
        }
    }

}
