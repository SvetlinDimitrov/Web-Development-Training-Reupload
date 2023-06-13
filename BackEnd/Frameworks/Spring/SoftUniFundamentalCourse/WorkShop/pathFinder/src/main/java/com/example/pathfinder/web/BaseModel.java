package com.example.pathfinder.web;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public abstract class BaseModel {

    public ModelAndView view(String path , ModelAndView modelAndView){
        modelAndView.setViewName(path);
        return modelAndView;
    }
    public ModelAndView view(String path){
        return view(path , new ModelAndView());
    }

    public ModelAndView redirect(String path , ModelAndView modelAndView){
        modelAndView.setViewName("redirect:/" + path);
        return modelAndView;
    }
}
