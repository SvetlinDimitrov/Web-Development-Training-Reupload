package com.example.battleships.web.controllers;

import com.example.battleships.domain.bindingViews.ViewShip;
import com.example.battleships.domain.bindingViews.ViewUser;
import com.example.battleships.service.ship.ShipService;
import com.example.battleships.web.constants.DefaultModel;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("ships")
@Controller
@AllArgsConstructor
public class ShipController extends DefaultModel {

    private ShipService service;

    @GetMapping("/add")
    public ModelAndView addShipPage( HttpSession session) {
        if(session.getAttribute("user") == null){
            return view("index");
        }
        return view("ship-add.html");
    }

    @PostMapping("/add")
    public ModelAndView addShip(@Valid @ModelAttribute(name = "ship") ViewShip ship,
                                BindingResult result,
                                ModelAndView modelAndView,
                                HttpSession session) {

        if (result.hasErrors()) {
            return view("ship-add.html");
        }
        ViewUser user = (ViewUser)session.getAttribute("user");
        service.addShip(ship , user);

        return redirect("/home" , modelAndView);
    }

    @ModelAttribute(name = "ship")
    public ViewShip ship() {
        return new ViewShip();
    }

}
