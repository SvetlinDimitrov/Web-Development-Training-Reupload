package com.example.mobileleweb.service.User;

import com.example.mobileleweb.domain.constants.Role;
import com.example.mobileleweb.domain.entity.User;
import com.example.mobileleweb.domain.entity.UserRole;
import com.example.mobileleweb.domain.modelViewEntity.UserView;
import com.example.mobileleweb.domain.viewDtos.RegisterUserDto;
import com.example.mobileleweb.repo.UserRepository;
import com.example.mobileleweb.service.UserRole.UserRoleService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserRoleService userRoleService;
    private ModelMapper modelMapper;
    @Override
    public void register(RegisterUserDto registerUserDto) {
        UserView view = modelMapper.map(registerUserDto, UserView.class);
        //TODO::validation , check the user if it is already in the data
        User user = modelMapper.map(view, User.class);
        userRepository.save(user);
        UserRole role = userRoleService.findByRole(registerUserDto.getRole());
        user.getRoles().add(role);
        if(userRepository.count() == 0){
            user.getRoles().add(userRoleService.findByRole(Role.Admin));
        }
        userRepository.save(user);
    }
}
