package com.example.mobileleweb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/brands/all")
public class BrandController {

    @GetMapping
    public ModelAndView getAllModels(ModelAndView modelAndView){
        modelAndView.setViewName("brands");
        return modelAndView;
    }
}
