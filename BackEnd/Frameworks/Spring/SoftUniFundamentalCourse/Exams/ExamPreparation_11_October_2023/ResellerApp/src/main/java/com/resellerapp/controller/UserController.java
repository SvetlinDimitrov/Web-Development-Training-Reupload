package com.resellerapp.controller;

import com.resellerapp.config.UserPrincipal;
import com.resellerapp.model.dtos.RegisterUserDto;
import com.resellerapp.model.dtos.ViewOffer;
import com.resellerapp.model.dtos.ViewUser;
import com.resellerapp.service.UserService;
import lombok.Data;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@Data
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ModelAndView home(@AuthenticationPrincipal UserPrincipal user,
                             HttpSession session){

        ModelAndView modelAndView = new ModelAndView();
        session.setAttribute("user" , user);

        ViewUser viewUser = userService.getViewUser(user.getId());
        List<ViewUser> users = userService.getAllViewUsersWithoutCurrent(user.getId());
        Long allOffersCount = users.stream().mapToLong(u -> u.getOffers().size()).sum();

        modelAndView.addObject("user" ,  viewUser);
        modelAndView.addObject("allUsers" ,  users);
        modelAndView.addObject("allOffersCount" ,  allOffersCount);
        modelAndView.setViewName("home");

        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("registerDto",new RegisterUserDto());
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute (name = "registerDto") RegisterUserDto registerUserDto,
                                 BindingResult result ,
                                 ModelAndView modelAndView){

        checkUserCredentials(registerUserDto, result);

        if(result.hasErrors()){
            modelAndView.setViewName("register");
            modelAndView.addObject("registerDto" , registerUserDto);
            return modelAndView;
        }

        userService.register(registerUserDto);
        modelAndView.setViewName("redirect:" + "/user/login");
        return modelAndView;
    }

    public void checkUserCredentials(RegisterUserDto registerUserDto, BindingResult result){
        if(userService.usedUsername(registerUserDto.getUsername())){
            result.rejectValue("username", "error.code", "Username is used");
        }

        if(userService.usedEmail(registerUserDto.getEmail())){
            result.rejectValue("email", "error.code", "email is used");
        }

        if(!registerUserDto.getPassword().equals(registerUserDto.getConfirmPassword())){
            result.rejectValue("confirmPassword", "error.code", "password is wrong");

        }
    }

}
