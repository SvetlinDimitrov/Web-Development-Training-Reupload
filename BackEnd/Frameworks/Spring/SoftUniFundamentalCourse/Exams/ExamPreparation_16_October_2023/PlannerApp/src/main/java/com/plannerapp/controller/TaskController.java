package com.plannerapp.controller;

import com.plannerapp.model.dtos.TaskAddDto;
import com.plannerapp.model.dtos.UserLogged;
import com.plannerapp.service.TaskService;
import com.plannerapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ModelAndView task(HttpSession session){

        if(session.getAttribute("user") == null){
            return new ModelAndView("redirect:/user/login");
        }

        ModelAndView modelAndView = new ModelAndView("task-add");
        modelAndView.addObject("taskAdd" , new TaskAddDto());

        return modelAndView;
    }

    @PostMapping
    public ModelAndView task(@Valid @ModelAttribute(value = "taskAdd") TaskAddDto taskAddDto,
                             BindingResult bindingResult,
                             ModelAndView modelAndView){

        if(bindingResult.hasErrors()){
            modelAndView.setViewName("task-add");
            return modelAndView;
        }

        taskService.add(taskAddDto);

        modelAndView.setViewName("redirect:/");
        return modelAndView;

    }

    @GetMapping("/remove/{taskId}")
    public ModelAndView removeTask(HttpSession session, @PathVariable Long taskId){

        if(session.getAttribute("user") == null){
            return new ModelAndView("redirect:/user/login");
        }

        taskService.removeTask(taskId);

        return new ModelAndView("redirect:/");
    }

    @GetMapping("/return/{taskId}")
    public ModelAndView returnTask(HttpSession session, @PathVariable Long taskId){

        if(session.getAttribute("user") == null){
            return new ModelAndView("redirect:/user/login");
        }

        taskService.returnTask(taskId);

        return new ModelAndView("redirect:/");
    }

    @GetMapping("/assign/{taskId}")
    public ModelAndView assignTask(HttpSession session, @PathVariable Long taskId){

        UserLogged user = (UserLogged) session.getAttribute("user");
        if(user == null){
            return new ModelAndView("redirect:/user/login");
        }

        taskService.assignTask(taskId , user);

        return new ModelAndView("redirect:/");
    }

}
