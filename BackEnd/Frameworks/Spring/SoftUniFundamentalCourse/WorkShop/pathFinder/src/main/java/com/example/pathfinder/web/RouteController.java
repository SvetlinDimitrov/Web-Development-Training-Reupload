package com.example.pathfinder.web;

import com.example.pathfinder.domain.bindingViews.ViewRoute;
import com.example.pathfinder.domain.dtos.RegisterRouteDto;
import com.example.pathfinder.service.category.CategoryService;
import com.example.pathfinder.service.route.RouteService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/routes")
public class RouteController extends BaseModel {

    private RouteService routeService;
    private CategoryService categoryService;

    @GetMapping("")
    public ModelAndView getRoutes(ModelAndView modelAndView,
                                  HttpSession session){

        if(session.getAttribute("loggedUser") == null){
            return redirect("users/login", new ModelAndView());
        }

        List<ViewRoute> routes = routeService.getAllViewRoutes();
        modelAndView.addObject("routes" , routes);
        return view("routes.html" , modelAndView);
    }

    @GetMapping("/details/{id}")
    public ModelAndView getDetailAboutTheRoute(@PathVariable Long id,
                                       ModelAndView modelAndView,
                                               HttpSession session){
        if(session.getAttribute("loggedUser") == null){
            return redirect("users/login", new ModelAndView());
        }
        ViewRoute route = routeService.getViewRouteById(id);
        modelAndView.addObject("route",route);
        modelAndView.addObject("message" , "");
        return view("route-details.html" , modelAndView);
    }

    @GetMapping("/add")
    public ModelAndView getAddPage(ModelAndView modelAndView,
                                   HttpSession session){

        if(session.getAttribute("loggedUser") == null){
            return redirect("users/login", new ModelAndView());
        }
        modelAndView.addObject("registerRoute" , new RegisterRouteDto());
        return view("add-route.html" , modelAndView);
    }

    @PostMapping("/add")
    public ModelAndView addRoute(@Valid @ModelAttribute(name = "registerRoute")RegisterRouteDto registerRouteDto,
                                 BindingResult result,
                                 ModelAndView modelAndView,
                                 HttpSession session) throws IOException {

        if(session.getAttribute("loggedUser") == null){
            return redirect("users/login", new ModelAndView());
        }

        if(result.hasErrors()){
            modelAndView.addObject("registerRoute" , registerRouteDto);
            return view("add-route.html" , modelAndView);
        }
        Long id = (Long) session.getAttribute("loggedUser");
        routeService.saveRote(registerRouteDto , id);
        return redirect("routes" , modelAndView);
    }

    @GetMapping(value = {"/pedestrian/{level}","/bicycle/{level}","/motorcycle/{level}","/car/{level}"})
    public ModelAndView getUniqueCategorical(ModelAndView modelAndView, @PathVariable Integer level){
        modelAndView.addObject("routes" ,routeService.getAllViewRoutesByCategoryConstOriginalId(level));
        return switch (level) {
            case 1 -> view("pedestrian.html", modelAndView);
            case 2 -> view("bicycle.html", modelAndView);
            case 3 -> view("motorcycle.html", modelAndView);
            default -> view("car.html", modelAndView);
        };
    }
}
