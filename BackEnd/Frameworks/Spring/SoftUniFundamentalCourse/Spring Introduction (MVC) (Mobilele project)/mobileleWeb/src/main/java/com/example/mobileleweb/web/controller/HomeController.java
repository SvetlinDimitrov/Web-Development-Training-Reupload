package com.example.mobileleweb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public ModelAndView getHome(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        return modelAndView;
    }

}