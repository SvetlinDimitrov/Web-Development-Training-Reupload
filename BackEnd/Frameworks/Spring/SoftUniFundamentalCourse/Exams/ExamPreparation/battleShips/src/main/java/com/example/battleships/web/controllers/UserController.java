package com.example.battleships.web.controllers;

import com.example.battleships.domain.bindingViews.LoginUserDto;
import com.example.battleships.domain.bindingViews.ViewUser;
import com.example.battleships.service.user.UserService;
import com.example.battleships.web.constants.DefaultModel;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RequestMapping("users")
@Controller
@AllArgsConstructor
public class UserController extends DefaultModel {

    private UserService userService;

    @GetMapping("/login")
    public ModelAndView getLoginPage(HttpSession session){
        session.removeAttribute("user");
        return view("login.html");
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid @ModelAttribute(name = "loginUser") LoginUserDto loginUser,
                              BindingResult result,
                              ModelAndView modelAndView ,
                              HttpSession session){
        Optional<ViewUser> user = userService.login(loginUser);
        if(result.hasErrors() || user.isEmpty()){
            return view("login.html" , modelAndView);
        }
        session.setAttribute("user" , user.get());
        return redirect("/home" , modelAndView);
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage(HttpSession session){
        session.removeAttribute("user");
        return view("register.html");
    }
    @PostMapping("/register")
    public ModelAndView registerUser(@Valid @ModelAttribute(name = "registerUser") ViewUser registerUser,
                                     BindingResult result,
                                     ModelAndView modelAndView){

        if(result.hasErrors()){
            return view("register.html" , modelAndView);
        }
        userService.register(registerUser);
        return redirect("/users/login" , modelAndView);
    }


    @GetMapping("/logout")
    public ModelAndView logoutUser(HttpSession session){
        session.removeAttribute("user");
        return redirect("/" , new ModelAndView());
    }

    @ModelAttribute(name = "registerUser")
    public ViewUser registerUser(){
        return new ViewUser();
    }

    @ModelAttribute(name = "loginUser")
    public LoginUserDto loginUser(){
        return new LoginUserDto();
    }
}
