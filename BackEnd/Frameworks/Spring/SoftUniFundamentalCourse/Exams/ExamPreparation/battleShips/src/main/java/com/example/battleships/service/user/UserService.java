package com.example.battleships.service.user;

import com.example.battleships.domain.bindingViews.LoginUserDto;
import com.example.battleships.domain.bindingViews.ViewShip;
import com.example.battleships.domain.bindingViews.ViewUser;
import com.example.battleships.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean isNotPresentUsername(String name);
    boolean isNotPresentEmail(String email);

    void register(ViewUser user);

    Optional<ViewUser> login(LoginUserDto loginUser);

    User findByUsername(String username);

    List<ViewShip> getAllUserShips(ViewUser user);
}
