package com.example.battleships.service.ship;

import com.example.battleships.domain.bindingViews.ViewShip;
import com.example.battleships.domain.bindingViews.ViewUser;
import com.example.battleships.domain.constants.CategoryConstants;
import com.example.battleships.domain.entity.Category;
import com.example.battleships.domain.entity.Ship;
import com.example.battleships.domain.entity.User;
import com.example.battleships.repos.ShipRepository;
import com.example.battleships.service.category.CategoryService;
import com.example.battleships.service.user.UserService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
    public void addShip(ViewShip viewShip, ViewUser viewUser) {
        Ship ship = viewShip.toShip();
        User user = userService.findByUsername(viewUser.getUsername());
        Category category = categoryService.findByCategoryName(viewShip.getCategory());
        ship.setCategory(category);
        ship.setUser(user);
        shipRepository.save(ship);
    }

    @Override
    public List<ViewShip> getAllShipsNotOwnedByTheCurrentUser(ViewUser user) {
        return shipRepository.findAllShipsNotWithTheCurrentUser(user.getUsername())
                .stream()
                .map(Ship::toViewShip)
                .toList();
    }

    @Override
    public List<ViewShip> getAllShips() {
        return shipRepository.findAll()
                .stream()
                .map(Ship::toViewShip)
                .sorted((f,s) ->{
                    if(f.getName().length() < s.getName().length()){
                        return -1;
                    }
                    if(f.getHealth() < s.getHealth()){
                        return -1;
                    }
                    if(f.getPower() < s.getPower()){
                        return -1;
                    }
                    return 1;
                })
                .toList();
    }

    @Override
    public void figth(Long idAttacker, Long idDefender) {
        Ship attacker = shipRepository.findById(idAttacker).get();
        Ship defender = shipRepository.findById(idDefender).get();

        defender.setHealth(defender.getHealth() - attacker.getPower());

        if(defender.getHealth() <= 0){
            shipRepository.delete(defender);
        }else{
            shipRepository.save(defender);
        }


    }


    @PostConstruct
    public void addShips() {
        if(shipRepository.findAll().size() < 5) {
            shipRepository.saveAll(
                    List.of(
                            Ship.builder()
                                    .name("peshoShip")
                                    .power(100L)
                                    .health(100L)
                                    .created(LocalDate.now())
                                    .category(categoryService.findByCategoryName(CategoryConstants.BATTLE))
                                    .user(userService.findByUsername("Pesho"))
                                    .build(),
                            Ship.builder()
                                    .name("gOSHOsILATA")
                                    .power(50L)
                                    .health(100L)
                                    .created(LocalDate.now())
                                    .category(categoryService.findByCategoryName(CategoryConstants.PATROL))
                                    .user(userService.findByUsername("Pesho"))
                                    .build(),
                            Ship.builder()
                                    .name("4orapiNe")
                                    .power(10L)
                                    .health(10L)
                                    .created(LocalDate.now())
                                    .category(categoryService.findByCategoryName(CategoryConstants.BATTLE))
                                    .user(userService.findByUsername("Pesho"))
                                    .build(),
                            Ship.builder()
                                    .name("SOFTuNIsHIP")
                                    .power(1L)
                                    .health(1L)
                                    .created(LocalDate.now())
                                    .category(categoryService.findByCategoryName(CategoryConstants.BATTLE))
                                    .user(userService.findByUsername("Pesho"))
                                    .build(),
                            Ship.builder()
                                    .name("gospodBogaSHIP")
                                    .power(10000L)
                                    .health(10000L)
                                    .created(LocalDate.now())
                                    .category(categoryService.findByCategoryName(CategoryConstants.CARGO))
                                    .user(userService.findByUsername("Pesho"))
                                    .build()
                    ));
        }
    }
}
