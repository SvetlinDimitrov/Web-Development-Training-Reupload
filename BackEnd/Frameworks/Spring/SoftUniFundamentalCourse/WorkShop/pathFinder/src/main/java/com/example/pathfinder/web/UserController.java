package com.example.pathfinder.web;

import com.example.pathfinder.domain.bindingViews.ViewUser;
import com.example.pathfinder.domain.dtos.LoginUserDto;
import com.example.pathfinder.domain.dtos.RegisterUserDto;
import com.example.pathfinder.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
                              LoginUserDto loginUserDto,
                              HttpSession session){

        clearSession(session);
        ViewUser login = userService.login(loginUserDto);

        if( login != null){
            getPermissions(session, login);
            return redirect("" , modelAndView);
        }

        return redirect("users/login" , modelAndView);

    }
    @GetMapping("/loggout")
    public ModelAndView loggout(HttpSession session){
        clearSession(session);
        return redirect("" , new ModelAndView());
    }

    @GetMapping("/profile")
    public ModelAndView profile(ModelAndView modelAndView){
        return view("profile" , modelAndView);
    }

    private static void clearSession(HttpSession session) {
        session.removeAttribute("loggedUser");
        session.removeAttribute("admin");
        session.removeAttribute("user");
    }

    private static void getPermissions(HttpSession session, ViewUser login) {
        session.setAttribute("loggedUser" , login.getId());

        if(login.isAdmin()){
            session.setAttribute("admin" , true);
        }else{
            session.setAttribute("user" , true);
        }
    }

}
