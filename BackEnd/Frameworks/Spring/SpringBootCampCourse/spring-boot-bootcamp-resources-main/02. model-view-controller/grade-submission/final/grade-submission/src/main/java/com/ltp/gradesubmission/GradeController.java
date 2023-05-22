package com.ltp.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GradeController {

    @GetMapping("/")
    public String fuckThatIDontNeedThat(Model model){
        List<SuperHumnas> list = new ArrayList<>();
        list.add(new SuperHumnas("toshop" , "ogun" , 15));
        list.add(new SuperHumnas("tsssssoshop" , "ogunSvoda" , 25));
        model.addAttribute("superHumans" , list);
        return "fuck";
    }
}