package com.example.battleships.service.ship;

import com.example.battleships.domain.bindingViews.ViewShip;
import com.example.battleships.domain.bindingViews.ViewUser;
import com.example.battleships.domain.entity.Category;
import com.example.battleships.domain.entity.Ship;
import com.example.battleships.domain.entity.User;
import com.example.battleships.repos.ShipRepository;
import com.example.battleships.service.category.CategoryService;
import com.example.battleships.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShipServiceImpl implements ShipService {

    private ShipRepository shipRepository;
    private UserService userService;
    private CategoryService categoryService;

    @Override
    public boolean isNotPresent(String name) {
        return shipRepository.findByName(name).isEmpty();
    }

    @Override
    public void addShip(ViewShip viewShip , ViewUser viewUser) {
        Ship ship = viewShip.toShip();
        User user = userService.findByUsername(viewUser.getUsername());
        Category category = categoryService.findByCategoryName(viewShip.getCategory());
        ship.setCategory(category);
        ship.setUser(user);
        shipRepository.save(ship);
    }
}
