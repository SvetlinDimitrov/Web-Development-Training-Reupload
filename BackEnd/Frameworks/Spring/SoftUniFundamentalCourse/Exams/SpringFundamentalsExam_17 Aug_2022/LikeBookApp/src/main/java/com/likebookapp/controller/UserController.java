package com.likebookapp.controller;

import com.likebookapp.config.security.UserLogged;
import com.likebookapp.model.dtos.UserLoginDto;
import com.likebookapp.model.dtos.UserRegisterDto;
import com.likebookapp.service.UserService;
import com.likebookapp.util.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/login")
    public ModelAndView login(@AuthenticationPrincipal UserLogged userLogged){

        if(userLogged != null){
            return new ModelAndView("redirect:/");
        }

        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("loginDto" , new UserLoginDto());
        return modelAndView;
    }

    @GetMapping(value = "/register")
    public ModelAndView register(@AuthenticationPrincipal UserLogged userLogged) {

        if(userLogged != null){
            return new ModelAndView("redirect:/");
        }

        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("registerDto" , new UserRegisterDto());

        return modelAndView;
    }

    @PostMapping(value = "/register")
    public ModelAndView register(@Valid @ModelAttribute("registerDto") UserRegisterDto userRegisterDto,
                                 BindingResult result ,
                                 ModelAndView modelAndView) {

        modelAndView.setViewName("redirect:/user/login");

        Validator.checkPasswordsEquality.accept(userRegisterDto , result);

        if(result.hasErrors()){
            modelAndView.addObject("registerDto" , userRegisterDto);
            modelAndView.setViewName("register");
            return modelAndView;
        }

        userService.registerUser(userRegisterDto);

        return modelAndView;
    }

}
