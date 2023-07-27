package com.example.mobileleweb.web.controller;

import com.example.mobileleweb.domain.entity.UserEntity;
import com.example.mobileleweb.domain.modelViewEntity.UserView;
import com.example.mobileleweb.domain.viewDtos.ViewUser;
import com.example.mobileleweb.service.User.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class HomeController {
    private UserService userService;

    @GetMapping
    public ModelAndView getHome(HttpSession session ,
                                Principal principal ,
                                ModelAndView modelAndView){
        ViewUser user = userService.getUserByUsername(principal.getName()).toUserView();
        session.setAttribute("user" ,user);
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
