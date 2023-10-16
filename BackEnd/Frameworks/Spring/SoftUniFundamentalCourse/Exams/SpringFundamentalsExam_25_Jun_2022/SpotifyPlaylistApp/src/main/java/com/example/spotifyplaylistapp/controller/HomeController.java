package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.config.security.LoggedUser;
import com.example.spotifyplaylistapp.service.SongServiceImp;
import com.example.spotifyplaylistapp.service.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class HomeController {

    private final UserServiceImp userServiceImp;
    private final SongServiceImp songServiceImp;

    @GetMapping
    public ModelAndView home (@AuthenticationPrincipal LoggedUser loggedUser,
                             HttpSession session,
                             ModelAndView modelAndView){

        modelAndView.setViewName("index");

        if(loggedUser != null){
            modelAndView.addObject("user" , userServiceImp.getViewUser(loggedUser.getId()));
            modelAndView.addObject("totalMinuteUserPlayList" , userServiceImp.getTotalMinuteUserPlayList(loggedUser.getId()));
            modelAndView.addObject("rockSongs" , songServiceImp.getRockViewSongs());
            modelAndView.addObject("popSongs" , songServiceImp.getPopViewSongs());
            modelAndView.addObject("jazzSongs" , songServiceImp.getJazzViewSongs());
            session.setAttribute("user" , loggedUser);
            modelAndView.setViewName("home");
            return modelAndView;
        }

        return modelAndView;
    }

}
