package com.example.validationexercise.web.constants;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public abstract class DefaultModel {
    public ModelAndView view(String path){
        return view(path , new ModelAndView());
    }

    public ModelAndView view(String path , ModelAndView modelAndView){
        modelAndView.setViewName(path);
        return modelAndView;
    }

    public ModelAndView redirect(String path , ModelAndView modelAndView){
        return  view("redirect:" + path , modelAndView);
    }

}
