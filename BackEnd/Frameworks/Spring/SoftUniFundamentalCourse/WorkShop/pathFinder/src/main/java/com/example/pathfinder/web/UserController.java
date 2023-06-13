package com.example.pathfinder.web;

import com.example.pathfinder.domain.dtos.LoginUserDto;
import com.example.pathfinder.domain.dtos.RegisterUserDto;
import com.example.pathfinder.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UserController  extends BaseModel{
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView getLoginPage(ModelAndView modelAndView){
        modelAndView.addObject("loginUser" , new LoginUserDto());
        return view("login" , modelAndView);
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage(ModelAndView modelAndView){
        modelAndView.addObject("registerUser" , new RegisterUserDto());
        return view("register" , modelAndView);
    }

    @PostMapping("/register")
    public ModelAndView register(ModelAndView modelAndView,
                                 RegisterUserDto registerUserDto){

        if(userService.register(registerUserDto)){
            return redirect("users/login" , modelAndView);
        }
        return redirect("users/register" , modelAndView);

    }
    @PostMapping("/login")
    public ModelAndView login(ModelAndView modelAndView,
                                 LoginUserDto loginUserDto){

        if(userService.login(loginUserDto)){
            return redirect("" , modelAndView);
        }
        return redirect("users/login" , modelAndView);

    }

}
