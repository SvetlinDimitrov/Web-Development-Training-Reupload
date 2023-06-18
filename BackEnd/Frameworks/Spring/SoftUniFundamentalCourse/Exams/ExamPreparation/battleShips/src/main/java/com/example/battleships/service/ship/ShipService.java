package com.example.battleships.service.ship;

import com.example.battleships.domain.bindingViews.ViewShip;
import com.example.battleships.domain.bindingViews.ViewUser;

import java.util.List;

public interface ShipService {
    boolean isNotPresent(String name);

    void addShip(ViewShip ship , ViewUser user);

    List<ViewShip> getAllShipsNotOwnedByTheCurrentUser(ViewUser user);

    List<ViewShip> getAllShips();

    void figth(Long idAttacker, Long idDefender);
}
