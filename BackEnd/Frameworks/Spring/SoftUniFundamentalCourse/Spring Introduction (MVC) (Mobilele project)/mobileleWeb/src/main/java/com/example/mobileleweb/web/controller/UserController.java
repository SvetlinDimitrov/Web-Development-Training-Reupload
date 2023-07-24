package com.example.mobileleweb.web.controller;

import com.example.mobileleweb.domain.constants.Role;
import com.example.mobileleweb.domain.viewDtos.RegisterUserDto;
import com.example.mobileleweb.service.User.UserService;
import com.example.mobileleweb.web.constants.BaseModelAndView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
    public ModelAndView getRegister(ModelAndView modelAndView) {

        modelAndView.addObject("userRegister", new RegisterUserDto());
        modelAndView.addObject("roles", Role.values());

        return view("auth-register", modelAndView);
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute(name = "userRegister") RegisterUserDto user,
                                 BindingResult result,
                                 ModelAndView modelAndView) {
        if (result.hasErrors()) {
            modelAndView.addObject("roles", Role.values());
            return view("auth-register", modelAndView);
        }
        userService.register(user);
        return redirect("/users/login", modelAndView);
    }

    @GetMapping("/login")
    public ModelAndView getLogin() {
        return view("auth-login", new ModelAndView());
    }

}
