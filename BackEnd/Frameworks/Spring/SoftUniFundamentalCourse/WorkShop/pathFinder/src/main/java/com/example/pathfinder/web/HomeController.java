package com.example.pathfinder.web;

import com.example.pathfinder.domain.constants.CategoryConstant;
import com.example.pathfinder.service.route.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class HomeController extends BaseModel {


    @GetMapping({"" , "/home"})
    public ModelAndView getHome(ModelAndView modelAndView){
        return view("index");
    }

    @GetMapping("/about")
    public ModelAndView getAboutPage(){
        return view("about.html");
    }
}
