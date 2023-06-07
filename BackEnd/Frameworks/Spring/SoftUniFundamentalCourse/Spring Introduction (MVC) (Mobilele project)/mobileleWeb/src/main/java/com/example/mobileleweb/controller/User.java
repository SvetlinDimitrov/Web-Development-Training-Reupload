package com.example.mobileleweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class User {

    @GetMapping("/register")
    public ModelAndView getRegister(ModelAndView modelAndView){
        modelAndView.setViewName("auth-register");
        return modelAndView;
    }
    //PostMapping register
    @GetMapping("/login")
    public ModelAndView getLogin(ModelAndView modelAndView){
        modelAndView.setViewName("auth-login");
        return modelAndView;
    }
    //PostMapping register

}
