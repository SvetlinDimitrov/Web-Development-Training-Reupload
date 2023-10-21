package com.dictionaryapp.controller;

import com.dictionaryapp.model.dtos.WordAddDto;
import com.dictionaryapp.service.WordService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@RequestMapping("/word")
public class WordController {

    private final WordService wordService;

    @GetMapping("/add")
    public ModelAndView word(ModelAndView modelAndView,
                             HttpSession session) {

        if (session.getAttribute("user") == null) {
            modelAndView.setViewName("redirect:/user/login");
            return modelAndView;
        }

        modelAndView.setViewName("word-add");
        modelAndView.addObject("wordAddDto", new WordAddDto());

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView word(@Valid @ModelAttribute(value = "wordAddDto") WordAddDto wordAddDto,
                             BindingResult result,
                             ModelAndView modelAndView,
                             HttpSession session) {

        if (result.hasErrors()) {
            modelAndView.setViewName("word-add");
            modelAndView.addObject("wordAddDto", wordAddDto);
            return modelAndView;
        }
        String userName = (String) session.getAttribute("user");
        wordService.addWord(wordAddDto , userName);

        modelAndView.setViewName("redirect:/");

        return modelAndView;
    }

    @GetMapping("/remove/{wordId}")
    public ModelAndView removeWordById(@PathVariable Long wordId){
        wordService.removeWordById(wordId);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/remove-all")
    public ModelAndView removeAll(){
        wordService.removeAllWords();
        return new ModelAndView("redirect:/");
    }
}
