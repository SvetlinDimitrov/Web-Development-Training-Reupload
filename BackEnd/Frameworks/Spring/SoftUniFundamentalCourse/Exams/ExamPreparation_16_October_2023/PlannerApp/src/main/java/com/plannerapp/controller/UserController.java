package com.plannerapp.controller;

import com.plannerapp.model.dtos.UserLoginDto;
import com.plannerapp.model.dtos.UserRegisterDto;
import com.plannerapp.service.UserService;
import com.plannerapp.util.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

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
    public ModelAndView register(@Valid @ModelAttribute(value = "registerDto") UserRegisterDto userRegisterDto,
                                 BindingResult result,
                                 ModelAndView modelAndView) {

        Validator.checkPasswords(userRegisterDto.getPassword() , userRegisterDto.getConfirmPassword() , result);

        if(result.hasErrors()){
            modelAndView.setViewName("register");
            modelAndView.addObject("registerDto" , userRegisterDto);
            return modelAndView;
        }

        userService.registerUser(userRegisterDto);
        modelAndView.setViewName("redirect:/user/login");

        return modelAndView;
    }
}
