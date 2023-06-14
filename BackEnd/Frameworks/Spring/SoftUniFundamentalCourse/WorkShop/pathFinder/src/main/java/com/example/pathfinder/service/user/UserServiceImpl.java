package com.example.pathfinder.service.user;

import com.example.pathfinder.domain.bindingViews.ViewRoles;
import com.example.pathfinder.domain.bindingViews.ViewUser;
import com.example.pathfinder.domain.constants.RoleConstant;
import com.example.pathfinder.domain.dtos.LoginUserDto;
import com.example.pathfinder.domain.dtos.RegisterUserDto;
import com.example.pathfinder.domain.entity.User;
import com.example.pathfinder.repos.RoleRepository;
import com.example.pathfinder.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper mapper;
    private RoleRepository roleRepository;

    @Override
    public boolean register(RegisterUserDto registerUserDto) {
        if(userRepository.findByUsername(registerUserDto.getUsername()).isEmpty()){
            ViewUser userView = mapper.map(registerUserDto, ViewUser.class);
            ViewRoles viewRoles = mapper.map(roleRepository.findByRole(RoleConstant.USER).get() , ViewRoles.class);
            userView.getRoles().add(viewRoles);
            User user = mapper.map(userView, User.class);
            userRepository.save(user);
            return true;
        }
        return  false;
    }

    @Override
    public ViewUser login(LoginUserDto loginUserDto){
        Optional<User> userInTheBase = userRepository.findByUsername(loginUserDto.getUsername());
        if(userInTheBase.isPresent() &&
                userInTheBase.get().getPassword().equals(loginUserDto.getPassword())){
            return mapper.map(userInTheBase.get() , ViewUser.class);
        }
        return null;
    }

}
