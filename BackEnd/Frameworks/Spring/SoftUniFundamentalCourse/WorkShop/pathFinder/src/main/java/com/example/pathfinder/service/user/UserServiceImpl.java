package com.example.pathfinder.service.user;

import com.example.pathfinder.domain.bindingViews.ViewRoles;
import com.example.pathfinder.domain.bindingViews.ViewUser;
import com.example.pathfinder.domain.constants.Level;
import com.example.pathfinder.domain.constants.RoleConstant;
import com.example.pathfinder.domain.dtos.LoginUserDto;
import com.example.pathfinder.domain.dtos.RegisterUserDto;
import com.example.pathfinder.domain.entity.User;
import com.example.pathfinder.repos.RoleRepository;
import com.example.pathfinder.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper mapper;
    private RoleRepository roleRepository;

    @Override
    public boolean register(RegisterUserDto registerUserDto) {

        ViewUser userView = mapper.map(registerUserDto, ViewUser.class);
        ViewRoles viewRoles = mapper.map(roleRepository.findByRole(RoleConstant.USER).get(), ViewRoles.class);
        userView.getRoles().add(viewRoles);
        User user = mapper.map(userView, User.class);
        user.setLevel(Level.BEGINNER);
        userRepository.save(user);
        return true;

    }

    @Override
    @Transactional
    public ViewUser login(LoginUserDto loginUserDto) {
        Optional<User> userInTheBase = userRepository.findByUsername(loginUserDto.getUsername());
        if (userInTheBase.isPresent() &&
                userInTheBase.get().getPassword().equals(loginUserDto.getPassword())) {
            return mapper.map(userInTheBase.get(), ViewUser.class);
        }
        return null;
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
        return mapper.map(findById(id) , ViewUser.class);
    }

    @Override
    public User findById(Long id){
        return userRepository.findById(id).orElseThrow();
    }

}
