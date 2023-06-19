package com.example.mobileleweb.web.controller;

import com.example.mobileleweb.web.constants.BaseModelAndView;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/offers")
public class OfferController extends BaseModelAndView {

    @GetMapping("/add")
    public ModelAndView getAddView(ModelAndView modelAndView,
                                   HttpSession session){
        if(session.getAttribute("loggedUser") == null){
            return redirect("/users/login" , modelAndView);
        }
        return view("offer-add.html" , modelAndView);
    }
    @GetMapping("/all")
    public ModelAndView getAllView(ModelAndView modelAndView,
                                   HttpSession session){
        if(session.getAttribute("loggedUser") == null){
            return redirect("/users/login" , modelAndView);
        }
        return view("offers.html" , modelAndView);
    }
}
