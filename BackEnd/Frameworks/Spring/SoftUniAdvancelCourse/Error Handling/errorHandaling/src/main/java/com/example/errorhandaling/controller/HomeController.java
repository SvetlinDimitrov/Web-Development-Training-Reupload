package com.example.errorhandaling.controller;

import com.example.errorhandaling.exeption.CustomException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public ModelAndView getHome(){
        throw new CustomException();
    }

    @ExceptionHandler(CustomException.class)
    public ModelAndView catchTheException(HttpServletResponse response , CustomException e){
        ModelAndView modelAndView = new ModelAndView();
        response.setStatus(500);
        modelAndView.addObject("error" , e.getMessage());
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
