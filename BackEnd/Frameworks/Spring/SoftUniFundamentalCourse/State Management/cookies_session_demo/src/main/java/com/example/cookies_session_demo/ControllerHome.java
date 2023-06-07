package com.example.cookies_session_demo;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ControllerHome {

    @GetMapping("/")
    public ModelAndView getHome(ModelAndView modelAndView,
                                @CookieValue(required = false , name = "firstName") String fname){
        modelAndView.setViewName("index");
        modelAndView.addObject("fname" , fname);
        return modelAndView;
    }

    @PostMapping("/")
    public ModelAndView createCookie(@RequestParam(required = false) String fname ,
                                     @RequestParam(required = false) String lname,
                                     HttpServletResponse response,
                                     ModelAndView modelAndView){
        Cookie cookie = new Cookie("firstName" , fname);
        response.addCookie(cookie);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
