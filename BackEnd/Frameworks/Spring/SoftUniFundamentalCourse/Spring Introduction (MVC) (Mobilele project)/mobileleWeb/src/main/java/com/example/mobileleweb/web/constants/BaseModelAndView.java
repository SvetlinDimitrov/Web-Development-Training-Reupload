package com.example.mobileleweb.web.constants;


import org.springframework.boot.Banner;
import org.springframework.web.servlet.ModelAndView;

public abstract class BaseModelAndView {

    public ModelAndView view(String viewName , ModelAndView modelAndView){
        modelAndView.setViewName(viewName);
        return modelAndView;
    }
    public ModelAndView view(String viewName){
       return view(viewName , new ModelAndView());
    }
    public ModelAndView redirect(String path , ModelAndView modelAndView){
        modelAndView.setViewName("redirect:" + path);
        return modelAndView;
    }
}
