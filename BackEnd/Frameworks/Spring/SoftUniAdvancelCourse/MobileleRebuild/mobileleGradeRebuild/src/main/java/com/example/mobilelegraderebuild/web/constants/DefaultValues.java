package com.example.mobilelegraderebuild.web.constants;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class DefaultValues {

    @ModelAttribute
    public void configTheModel(Model modelAndView){
        modelAndView.addAttribute("text" , "Welcome to MobiLelele");

    }

}