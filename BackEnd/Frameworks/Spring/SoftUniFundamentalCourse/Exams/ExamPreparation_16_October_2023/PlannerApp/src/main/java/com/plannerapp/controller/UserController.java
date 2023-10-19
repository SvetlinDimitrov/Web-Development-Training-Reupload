package com.plannerapp.controller;

import com.plannerapp.model.dtos.UserLogged;
import com.plannerapp.model.dtos.UserLoginDto;
import com.plannerapp.model.dtos.UserRegisterDto;
import com.plannerapp.service.UserService;
import com.plannerapp.util.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public ModelAndView login(HttpSession session){

        ModelAndView modelAndView = new ModelAndView("login");

        if(session.getAttribute("user") != null){
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        modelAndView.addObject("loginDto" , new UserLoginDto());
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView register(@Valid @ModelAttribute("loginDto") UserLoginDto userLoginDto ,
                                 BindingResult result,
                                 HttpSession session){

        ModelAndView modelAndView = new ModelAndView("redirect:/");

        if(result.hasErrors() || !userService.login(userLoginDto , result)){
            modelAndView.addObject("loginDto" , userLoginDto);
            modelAndView.setViewName("login");
            return modelAndView;
        }

        session.setAttribute("user" , new UserLogged(userLoginDto.getUsername()));

        return modelAndView;
    }


    @GetMapping("/register")
    public ModelAndView register(HttpSession session){

        ModelAndView modelAndView = new ModelAndView("register");

        if(session.getAttribute("user") != null){
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        modelAndView.addObject("registerDto" , new UserRegisterDto());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute("registerDto") UserRegisterDto userRegisterDto ,
                                 BindingResult result){
        ModelAndView modelAndView = new ModelAndView("redirect:/user/login");

        Validator.checkPasswordsEquality.accept(userRegisterDto , result);

        if(result.hasErrors()){
            modelAndView.addObject("registerDto" , userRegisterDto);
            modelAndView.setViewName("register");
            return modelAndView;
        }

        userService.registerUser(userRegisterDto);

        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session){
        session.removeAttribute("user");
        return new ModelAndView("redirect:/user/login");
    }
}
