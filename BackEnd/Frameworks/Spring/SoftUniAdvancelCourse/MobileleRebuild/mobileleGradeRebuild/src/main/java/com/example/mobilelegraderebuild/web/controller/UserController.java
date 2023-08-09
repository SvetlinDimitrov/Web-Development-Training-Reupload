package com.example.mobilelegraderebuild.web.controller;

import com.example.mobilelegraderebuild.domain.constants.Role;
import com.example.mobilelegraderebuild.domain.viewDtos.RegisterUserDto;
import com.example.mobilelegraderebuild.service.User.UserService;
import com.example.mobilelegraderebuild.web.constants.BaseModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
                                 ModelAndView modelAndView,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        if (result.hasErrors()) {
            modelAndView.addObject("roles", Role.values());
            return view("auth-register", modelAndView);
        }
        userService.register(user,request ,response);



        return redirect("/", modelAndView);
    }

    @GetMapping("/login")
    public ModelAndView getLogin(ModelAndView modelAndView) {
        modelAndView.setViewName("auth-login");
        return modelAndView;
    }

}
