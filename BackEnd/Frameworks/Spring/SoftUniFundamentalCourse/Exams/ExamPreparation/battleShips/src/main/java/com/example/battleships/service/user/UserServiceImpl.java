package com.example.battleships.service.user;

import com.example.battleships.domain.bindingViews.LoginUserDto;
import com.example.battleships.domain.bindingViews.ViewShip;
import com.example.battleships.domain.bindingViews.ViewUser;
import com.example.battleships.domain.entity.User;
import com.example.battleships.repos.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public boolean isNotPresentUsername(String name) {
        return userRepository.findByUsername(name).isEmpty();
    }

    @Override
    public boolean isNotPresentEmail(String email) {
        return userRepository.findByEmail(email).isEmpty();
    }

    @Override
    public void register(ViewUser user) {
        userRepository.save(user.toUser());
    }

    @Override
    public Optional<ViewUser> login(LoginUserDto loginUser) {
        Optional<User> user = userRepository.findByUsername(loginUser.getUsername());
        if (user.isEmpty() || !user.get().getPassword().equals(loginUser.getPassword())) {
            return Optional.empty();
        }
        return Optional.of(user.get().toViewUser());
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }

    @Override
    public List<ViewShip> getAllUserShips(ViewUser user) {
        return userRepository.findByUsername(user.getUsername())
                .get()
                .getShips()
                .stream()
                .map(ship -> ship.toViewShip())
                .toList();
    }

    @PostConstruct
    public void createAdmin() {
        if(userRepository.findByUsername("Pesho").isEmpty()){
            userRepository.save(User.builder()
                    .username("Pesho")
                    .password("Pesho")
                    .fullName("traktorista")
                    .email("propesho@abv.bg")
                    .build());
        }
    }
}
