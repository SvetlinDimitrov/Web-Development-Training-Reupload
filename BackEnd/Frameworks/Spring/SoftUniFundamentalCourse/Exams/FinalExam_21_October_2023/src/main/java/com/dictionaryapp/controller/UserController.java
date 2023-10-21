package com.dictionaryapp.controller;

import com.dictionaryapp.model.dtos.UserLoginDto;
import com.dictionaryapp.model.dtos.UserRegisterDto;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.util.Validator;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(path = "/login")
    public ModelAndView login(HttpSession session ,
                              ModelAndView modelAndView){

        if(session.getAttribute("user") != null){
            modelAndView.setViewName("redirect:/");
            return modelAndView ;
        }

        modelAndView.setViewName("login");
        modelAndView.addObject("userLoginDto" , new UserLoginDto());

        return modelAndView;
    }

    @PostMapping(path = "/login")
    public ModelAndView login(@Valid @ModelAttribute(value = "userLoginDto") UserLoginDto userLoginDto ,
                              BindingResult result ,
                              ModelAndView modelAndView,
                              HttpSession session){

        String user = userService.login(userLoginDto);

        if(result.hasErrors()){
            modelAndView.addObject("userLoginDto" , userLoginDto);
            modelAndView.setViewName("login");
            return modelAndView;
        }

        if(user == null){
            result.addError(new FieldError("userLoginDto" , "password" , "Incorrect username or password"));
            modelAndView.setViewName("login");
            return modelAndView;
        }

        session.setAttribute("user" , user);

        return new ModelAndView("redirect:/");
    }

    @GetMapping(path = "/register")
    public ModelAndView register(HttpSession session){

        if(session.getAttribute("user") != null){
            return new ModelAndView("redirect:/");
        }

        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("userRegisterDto" , new UserRegisterDto());

        return modelAndView;
    }

    @PostMapping(path = "/register")
    public ModelAndView register(@Valid @ModelAttribute(value = "userRegisterDto")UserRegisterDto userRegisterDto ,
                                 BindingResult result,
                                 ModelAndView modelAndView){

        Validator.checkPasswordsEquality.accept(userRegisterDto , result);

        if(result.hasErrors()){
            modelAndView.addObject("userRegisterDto" , userRegisterDto);
            modelAndView.setViewName("register");
            return modelAndView;
        }

        userService.registerUser(userRegisterDto);

        modelAndView.setViewName("redirect:/user/login");

        return modelAndView;
    }

    @GetMapping(path = "/logout")
    public ModelAndView logout(HttpSession session){
        session.removeAttribute("user");
        return new ModelAndView("redirect:/");
    }

}
