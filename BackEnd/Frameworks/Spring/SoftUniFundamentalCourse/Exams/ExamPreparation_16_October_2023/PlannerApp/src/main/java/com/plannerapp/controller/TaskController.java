package com.plannerapp.controller;

import com.plannerapp.config.security.LoggedUser;
import com.plannerapp.model.dtos.TaskAddDto;
import com.plannerapp.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/task")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ModelAndView addTask(){

        ModelAndView modelAndView = new ModelAndView("task-add");
        modelAndView.addObject("taskAddDto" , new TaskAddDto());

        return modelAndView;
    }

    @PostMapping
    public ModelAndView addTask(@Valid @ModelAttribute(name = "taskAddDto") TaskAddDto taskAddDto ,
                                BindingResult result ,
                                ModelAndView modelAndView){

        if(result.hasErrors()){
            modelAndView.addObject("taskAddDto" , taskAddDto);
            modelAndView.setViewName("task-add");
            return modelAndView;
        }

        taskService.registerTask(taskAddDto);
        modelAndView.setViewName("redirect:/");

        return modelAndView;
    }
    @GetMapping("/assign/{taskId}")
    public ModelAndView assignTask(@PathVariable Long taskId,
                                     @AuthenticationPrincipal LoggedUser loggedUser){
        taskService.assignTask(taskId , loggedUser.getId());

        return new ModelAndView("redirect:/");
    }
    @GetMapping("/return/{taskId}")
    public ModelAndView returnTask(@PathVariable Long taskId,
                                     @AuthenticationPrincipal LoggedUser loggedUser){
        taskService.returnTask(taskId , loggedUser.getId());

        return new ModelAndView("redirect:/");
    }

    @GetMapping("/remove/{taskId}")
    public ModelAndView removeTask(@PathVariable Long taskId,
                                   @AuthenticationPrincipal LoggedUser loggedUser){
        taskService.removeTask(taskId , loggedUser.getId());

        return new ModelAndView("redirect:/");
    }

}
