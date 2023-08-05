package com.example.pathfinder.web;

import com.example.pathfinder.domain.dtos.RegisterUserDto;
import com.example.pathfinder.service.user.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UserController extends BaseModel {
    private UserService userService;


    @GetMapping("/register")
    public ModelAndView getRegisterPage(ModelAndView modelAndView) {
        modelAndView.addObject("registerUser", new RegisterUserDto());
        return view("register", modelAndView);
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute(name = "registerUser") RegisterUserDto registerUserDto,
                                 BindingResult result,
                                 ModelAndView modelAndView) {
        if(result.hasErrors()){
            modelAndView.addObject("registerUser" , registerUserDto);
            return view("register" , modelAndView);
        }
        userService.register(registerUserDto);
        return redirect("users/login", modelAndView);

    }

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        return view("login", new ModelAndView());
    }

    @GetMapping("/profile")
    public ModelAndView profile() {
        return view("profile");
    }
    @GetMapping("/admin")
    public ModelAndView admin(){
        return redirect("" , new ModelAndView());
    }
}
