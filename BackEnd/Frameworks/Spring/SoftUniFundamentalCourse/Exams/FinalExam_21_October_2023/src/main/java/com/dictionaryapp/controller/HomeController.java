package com.dictionaryapp.controller;

import com.dictionaryapp.model.dtos.WordView;
import com.dictionaryapp.service.WordService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    private final WordService wordService;

    @GetMapping
    public ModelAndView getHome(HttpSession session ,
                                ModelAndView modelAndView){

        if(session.getAttribute("user") != null){
            modelAndView.setViewName("home");

            List<WordView> frenchWordViews = wordService.getFrenchWordViews();
            List<WordView> germanWordViews = wordService.getGermanWordViews();
            List<WordView> spanishWordViews = wordService.getSpanishWordViews();
            List<WordView> italianWordViews = wordService.getItalianWordViews();

            modelAndView.addObject("frenchWords" , frenchWordViews);
            modelAndView.addObject("germanWords" , germanWordViews);
            modelAndView.addObject("spanishWords" , spanishWordViews);
            modelAndView.addObject("italianWords" , italianWordViews);
            modelAndView.addObject("allWords" , frenchWordViews.size() + germanWordViews.size() + spanishWordViews.size() + italianWordViews.size());
            return modelAndView;
        }

        modelAndView.setViewName("index");
        return modelAndView;
    }

}
