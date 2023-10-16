package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.config.security.LoggedUser;
import com.example.spotifyplaylistapp.model.dtos.SongAddDto;
import com.example.spotifyplaylistapp.service.SongServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.plaf.PanelUI;
import javax.validation.Valid;

@RequestMapping("/song")
@Controller
@RequiredArgsConstructor
public class SongController {

    private final SongServiceImp songServiceImp;

    @GetMapping
    public ModelAndView addSong(){
        ModelAndView modelAndView = new ModelAndView("song-add");
        modelAndView.addObject("songDto" , new SongAddDto());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addSong(@Valid @ModelAttribute(value = "songDto") SongAddDto songAddDto,
                                BindingResult result,
                                ModelAndView modelAndView){

        if(result.hasErrors()){
            modelAndView.addObject("songDto" , songAddDto);
            modelAndView.setViewName("song-add");
            return modelAndView;
        }

        songServiceImp.addSong(songAddDto);

        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @GetMapping("/add/{songId}")
    public ModelAndView addSong(@PathVariable Long songId,
                                @AuthenticationPrincipal LoggedUser loggedUser){

        songServiceImp.promoteSong(songId , loggedUser.getId());

        return new ModelAndView("redirect:/");
    }

    @GetMapping("/removeAll")
    public ModelAndView modelAndView (@AuthenticationPrincipal LoggedUser loggedUser){
        songServiceImp.removeAllSongFromUser(loggedUser.getId());
        return new ModelAndView("redirect:/");
    }

}
