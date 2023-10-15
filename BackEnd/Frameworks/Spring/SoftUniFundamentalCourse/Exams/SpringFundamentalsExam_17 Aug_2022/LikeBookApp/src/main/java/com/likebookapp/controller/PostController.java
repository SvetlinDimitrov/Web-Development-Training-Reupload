package com.likebookapp.controller;

import com.likebookapp.config.security.UserLogged;
import com.likebookapp.model.dtos.PostCreateDto;
import com.likebookapp.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/post")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ModelAndView post(){
        ModelAndView modelAndView = new ModelAndView("post-add");
        modelAndView.addObject("postDto" , new PostCreateDto());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView post(@Valid @ModelAttribute (value = "postDto") PostCreateDto postCreateDto ,
                             BindingResult result ,
                             ModelAndView modelAndView ,
                             @AuthenticationPrincipal UserLogged userLogged){

        if(result.hasErrors()){
            modelAndView.setViewName("post-add");
            return modelAndView;
        }

        postService.addPost(postCreateDto , userLogged.getId());

        return new ModelAndView("redirect:/");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView removePost(@PathVariable Long id){
        postService.removePost(id);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/like/{id}")
    public ModelAndView removePost(@PathVariable Long id,
                                   @AuthenticationPrincipal UserLogged userLogged){
        postService.likePost(id,userLogged);
        return new ModelAndView("redirect:/");
    }

}
