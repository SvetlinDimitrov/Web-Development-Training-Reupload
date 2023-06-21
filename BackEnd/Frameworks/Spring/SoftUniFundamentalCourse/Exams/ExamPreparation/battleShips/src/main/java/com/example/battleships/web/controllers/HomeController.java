package com.example.battleships.web.controllers;

import com.example.battleships.domain.bindingViews.ViewShip;
import com.example.battleships.domain.bindingViews.ViewShipFifth;
import com.example.battleships.domain.bindingViews.ViewUser;
import com.example.battleships.service.ship.ShipService;
import com.example.battleships.service.user.UserService;
import com.example.battleships.web.constants.DefaultModel;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/")
@Controller
@AllArgsConstructor
public class HomeController extends DefaultModel {

    private UserService userService;
    private ShipService shipService;

    @GetMapping("")
    public ModelAndView getHome(){
        return view("index");
    }
    @GetMapping("/home")
    public ModelAndView warHome(ModelAndView modelAndView,
                                HttpSession session){

        if(session.getAttribute("user") == null){
            return view("index");
        }

        ViewUser user = (ViewUser) session.getAttribute("user");
        List<ViewShip> userShips = userService.getAllUserShips(user);
        modelAndView.addObject("userShips" , userShips);
        List<ViewShip> shipsByAnotherUsers = shipService.getAllShipsNotOwnedByTheCurrentUser(user);
        modelAndView.addObject("enemyShips" , shipsByAnotherUsers);
        List<ViewShip> allShips = shipService.getAllShips();
        modelAndView.addObject("allShips" , allShips);
        modelAndView.addObject("status" , new ViewShipFifth());
        return view("home" , modelAndView);
    }


    //TODO: fix sorting
    @PostMapping("/home")
    public ModelAndView resultsAfterWar(@Valid @ModelAttribute(name = "status") ViewShipFifth status,
                                        BindingResult result,
                                        ModelAndView modelAndView){
    if(result.hasErrors()){
        return redirect("/home" , modelAndView);
    }
        shipService.figth(status.getIdAttacker() , status.getIdDefender());
        return redirect("/home" , modelAndView);
    }
}
