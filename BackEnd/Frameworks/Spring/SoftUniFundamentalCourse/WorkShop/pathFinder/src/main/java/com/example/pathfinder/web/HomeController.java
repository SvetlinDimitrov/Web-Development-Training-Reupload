package com.example.pathfinder.web;

import com.example.pathfinder.domain.bindingViews.ViewUser;
import com.example.pathfinder.domain.dtos.LoginUserDto;
import com.example.pathfinder.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
@AllArgsConstructor
public class HomeController extends BaseModel {

    private final UserService userService;

    @GetMapping
    public ModelAndView getHome(@AuthenticationPrincipal LoginUserDto loginUserDto,
                                HttpSession session) {

        if (loginUserDto != null) {
            ViewUser user = userService.getViewUserById(loginUserDto.getId());
            session.setAttribute("loggedUser", user);
        }

        return view("index");
    }

    @GetMapping("/about")
    public ModelAndView getAboutPage() {
        return view("about.html");
    }
}


