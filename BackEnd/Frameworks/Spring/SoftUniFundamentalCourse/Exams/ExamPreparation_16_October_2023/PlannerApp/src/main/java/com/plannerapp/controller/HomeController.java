package com.plannerapp.controller;

import com.plannerapp.config.security.LoggedUser;
import com.plannerapp.model.dtos.ViewUser;
import com.plannerapp.model.entity.ViewTask;
import com.plannerapp.service.TaskService;
import com.plannerapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class HomeController {

    private final TaskService taskService;
    private final UserService userService;


    @GetMapping
    public ModelAndView getHome(@AuthenticationPrincipal LoggedUser loggedUser,
                                HttpSession session ,
                                ModelAndView modelAndView){

        modelAndView.setViewName("index");

        if(loggedUser != null){
            ViewUser viewUser = userService.getViewUser(loggedUser.getId());
            List<ViewTask> viewTaskList = taskService.getAllTaskExceptLoggedUserIdTasks(loggedUser.getId());

            session.setAttribute("user" , loggedUser);

            modelAndView.setViewName("home");
            modelAndView.addObject("viewUser" , viewUser);
            modelAndView.addObject("viewTaskList" , viewTaskList);

            return modelAndView;
        }

        session.removeAttribute("user");
        return modelAndView;
    }

}
