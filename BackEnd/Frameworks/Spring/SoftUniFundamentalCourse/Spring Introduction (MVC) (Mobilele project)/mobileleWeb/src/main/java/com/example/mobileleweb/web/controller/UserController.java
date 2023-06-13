package com.example.mobileleweb.web.controller;

import com.example.mobileleweb.domain.entity.Model;
import com.example.mobileleweb.domain.entity.User;
import com.example.mobileleweb.domain.viewDtos.LoginUserDto;
import com.example.mobileleweb.domain.viewDtos.RegisterUserDto;
import com.example.mobileleweb.service.User.UserService;
import com.example.mobileleweb.web.constants.BaseModelAndView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController extends BaseModelAndView {

    private UserService userService;

    @GetMapping("/register")
    public ModelAndView getRegister(){
        return view("auth-register");
    }
    @PostMapping("/register")
    public ModelAndView register(RegisterUserDto user, ModelAndView modelAndView){
        userService.register(user);
        return redirect("users/login" , modelAndView);
    }
    @GetMapping("/login")
    public ModelAndView getLogin(){
        return view("auth-login");
    }
    @PostMapping("/login")
    public ModelAndView login(LoginUserDto loginUserDto , ModelAndView modelAndView){
        //TODO:: check if the login user if valid
        return redirect("/" , modelAndView);
    }


}