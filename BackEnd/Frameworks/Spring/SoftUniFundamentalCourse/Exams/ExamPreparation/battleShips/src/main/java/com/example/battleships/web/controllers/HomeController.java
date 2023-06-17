package com.example.battleships.web.controllers;

import com.example.battleships.web.constants.DefaultModel;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/")
@Controller
public class HomeController extends DefaultModel {

    @GetMapping("")
    public ModelAndView getHome(){
        return view("index");
    }
    @GetMapping("/home")
    public ModelAndView warHome(){
        return view("home");
    }
}
