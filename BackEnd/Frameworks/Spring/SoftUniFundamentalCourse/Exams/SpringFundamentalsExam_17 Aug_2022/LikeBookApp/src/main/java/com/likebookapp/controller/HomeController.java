package com.likebookapp.controller;

import com.likebookapp.config.security.UserLogged;
import com.likebookapp.service.PostService;
import com.likebookapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    private final UserService userService;
    private final PostService postService;


    @GetMapping("/")
    public ModelAndView getHome (HttpSession session,
                                 @AuthenticationPrincipal UserLogged userLogged ,
                                 ModelAndView modelAndView){
        modelAndView.setViewName("index");

        if(userLogged != null){
            modelAndView.addObject("user" , userService.getLoggedUserView(userLogged.getId()));
            modelAndView.addObject("posts" ,postService.getAllPostsWithoutLoggedUser(userLogged.getId()));
            modelAndView.setViewName("home");
            session.setAttribute("user" , userLogged);
            return modelAndView;
        }
        return modelAndView;
    }

}
