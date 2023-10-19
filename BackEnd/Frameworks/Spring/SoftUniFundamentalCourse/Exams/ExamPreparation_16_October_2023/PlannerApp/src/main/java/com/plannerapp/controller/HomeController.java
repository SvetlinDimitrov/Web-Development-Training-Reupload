package com.plannerapp.controller;

import com.plannerapp.model.dtos.UserLogged;
import com.plannerapp.service.TaskService;
import com.plannerapp.service.UserService;
import lombok.RequiredArgsConstructor;
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
    private final TaskService taskService;

    @GetMapping
    public ModelAndView getHome(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("index");

        if(session.getAttribute("user") != null){
            modelAndView.addObject("viewUser" , userService.getViewUser((UserLogged) session.getAttribute("user")));
            modelAndView.addObject("allTaskViews" , taskService.getAllTaskWithoutLoggedUserTasks((UserLogged) session.getAttribute("user")));
            modelAndView.setViewName("home");
            return modelAndView;
        }
        return modelAndView;
    }
}
