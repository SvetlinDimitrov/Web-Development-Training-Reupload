package com.example.custom1;

import com.example.custom1.entity.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ControllerMain {
    private Map<String , User> users = new HashMap<>();

    @GetMapping("/")
    public String getForm(Model model) {
        model.addAttribute("user" , new User());
        return "sign-up";
    }

    @GetMapping("/result")
    public String getResult() {
        return "result";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(@Valid User user , BindingResult result){
        if(user.getFirstName().equals(user.getLastName())){
            result.rejectValue("lastName" , "secondName");
        }
        if(result.hasErrors()){
            return "sign-up";
        }
        users.put(user.getUserName() , user);
        return "redirect:/result";
    }

}
