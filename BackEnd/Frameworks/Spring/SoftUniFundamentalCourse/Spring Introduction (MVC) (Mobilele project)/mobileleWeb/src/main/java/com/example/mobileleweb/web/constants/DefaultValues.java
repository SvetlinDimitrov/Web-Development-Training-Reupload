package com.example.mobileleweb.web.constants;

import com.example.mobileleweb.domain.constants.Role;
import com.example.mobileleweb.domain.viewDtos.LoggedUser;
import com.example.mobileleweb.domain.viewDtos.LoginUserDto;
import com.example.mobileleweb.domain.viewDtos.RegisterUserDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class DefaultValues {

    @ModelAttribute
    public void configTheModel(Model modelAndView){
        modelAndView.addAttribute("text" , "Welcome to MobiLelele");
        modelAndView.addAttribute("roles" , Role.values());
        modelAndView.addAttribute("userRegister" , new RegisterUserDto());
        modelAndView.addAttribute("userLogin" , new LoginUserDto());
    }

}
