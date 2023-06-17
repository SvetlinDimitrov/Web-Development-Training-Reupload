package com.example.battleships.service.ship;

import com.example.battleships.domain.bindingViews.ViewShip;
import com.example.battleships.domain.bindingViews.ViewUser;

public interface ShipService {
    boolean isNotPresent(String name);

    void addShip(ViewShip ship , ViewUser user);
}
