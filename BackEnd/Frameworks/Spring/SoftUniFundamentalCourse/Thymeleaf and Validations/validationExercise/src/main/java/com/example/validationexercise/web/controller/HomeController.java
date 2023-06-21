package com.example.validationexercise.web.controller;

import com.example.validationexercise.web.constants.DefaultModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class HomeController  extends DefaultModel {
    @GetMapping
    public ModelAndView home(){
        return view("index");
    }

}
