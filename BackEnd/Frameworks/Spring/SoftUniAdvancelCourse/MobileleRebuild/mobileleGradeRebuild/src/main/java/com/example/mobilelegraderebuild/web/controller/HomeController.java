package com.example.mobilelegraderebuild.web.controller;

import com.example.mobilelegraderebuild.domain.viewDtos.SecurityViewUser;
import com.example.mobilelegraderebuild.service.User.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class HomeController {
    private UserService userService;

    @GetMapping
    public ModelAndView getHome(@AuthenticationPrincipal SecurityViewUser securityViewUser,
                                HttpSession session,
                                ModelAndView modelAndView) {

        session.setAttribute("user", securityViewUser);
        modelAndView.setViewName("index");

        return modelAndView;
    }

}
