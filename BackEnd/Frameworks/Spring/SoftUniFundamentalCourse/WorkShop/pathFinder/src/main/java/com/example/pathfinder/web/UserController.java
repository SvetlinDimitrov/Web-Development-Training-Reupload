package com.example.pathfinder.web;

import com.example.pathfinder.domain.bindingViews.ViewUser;
import com.example.pathfinder.domain.dtos.LoginUserDto;
import com.example.pathfinder.domain.dtos.RegisterUserDto;
import com.example.pathfinder.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView getLoginPage(ModelAndView modelAndView) {
        modelAndView.addObject("loginUser", new LoginUserDto());
        return view("login", modelAndView);
    }
    @PostMapping("/login")
    public ModelAndView login(@Valid @ModelAttribute(name = "loginUser") LoginUserDto loginUserDto,
                              BindingResult result,
                              ModelAndView modelAndView,
                              HttpSession session) {
        clearSession(session);
        ViewUser login = userService.login(loginUserDto);

        if(login == null){
            result.addError(new ObjectError("loginUser" , ""));
        }

        if(result.hasErrors()){
            modelAndView.addObject("loginUser" , loginUserDto);
            return view("login.html" , modelAndView);
        }

        getPermissions(session, login);

        return redirect("", modelAndView);
    }

    @GetMapping("/loggout")
    public ModelAndView loggout(HttpSession session) {
        clearSession(session);
        return redirect("", new ModelAndView());
    }

    @GetMapping("/profile")
    public ModelAndView profile(ModelAndView modelAndView,
                                HttpSession session) {

        if(session.getAttribute("loggedUser") == null){
            return redirect("", modelAndView);
        }
        Long id = (Long) session.getAttribute("loggedUser");
        ViewUser user = userService.getViewUserById(id);
        modelAndView.addObject("viewUser" , user);
        return view("profile", modelAndView);
    }

    private static void clearSession(HttpSession session) {
        session.removeAttribute("loggedUser");
        session.removeAttribute("admin");
        session.removeAttribute("user");
    }

    private static void getPermissions(HttpSession session, ViewUser login) {
        session.setAttribute("loggedUser", login.getId());

        if (login.isAdmin()) {
            session.setAttribute("admin", true);
        } else {
            session.setAttribute("user", true);
        }
    }

}
