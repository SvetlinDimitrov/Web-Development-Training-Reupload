package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.dtos.UserLoginDto;
import com.example.spotifyplaylistapp.model.dtos.UserRegisterDto;
import com.example.spotifyplaylistapp.service.UserServiceImp;
import com.example.spotifyplaylistapp.util.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceImp userServiceImp;

    @GetMapping("/login")
    public ModelAndView login() {

        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("loginDto" , new UserLoginDto());

        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView register() {

        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("registerDto" , new UserRegisterDto());

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute(value = "registerDto") UserRegisterDto registerDto,
                                 BindingResult result,
                                 ModelAndView modelAndView) {



        Validator.checkPasswords.accept(registerDto , result);

        if(result.hasErrors()){
            modelAndView.setViewName("register");
            modelAndView.addObject("registerDto" , registerDto);
            return modelAndView;
        }

        userServiceImp.registerUser(registerDto);

        modelAndView.setViewName("redirect:/user/login");
        return modelAndView;
    }

}
