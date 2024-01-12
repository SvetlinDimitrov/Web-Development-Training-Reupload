package com.ltp.workbook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerClass {

    @GetMapping("/shows")
    public String get(Model model){
        Movie movie = new Movie("Nepobedimite" , "JeisanSteitan" , "A+");
        model.addAttribute("movie" , movie);
        return "shows";
    }
}
