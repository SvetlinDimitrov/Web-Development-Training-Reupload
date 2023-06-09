package com.example.mobileleweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class Home {

    @GetMapping
    public ModelAndView getHome(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
