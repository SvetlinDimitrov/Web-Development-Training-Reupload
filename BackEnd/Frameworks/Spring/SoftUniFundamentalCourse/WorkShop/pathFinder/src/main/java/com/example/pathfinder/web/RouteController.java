package com.example.pathfinder.web;

import com.example.pathfinder.domain.bindingViews.ViewRoute;
import com.example.pathfinder.domain.dtos.LoginUserDto;
import com.example.pathfinder.domain.dtos.RegisterRouteDto;
import com.example.pathfinder.domain.dtos.UploadPictureDto;
import com.example.pathfinder.service.picture.PictureService;
import com.example.pathfinder.service.route.RouteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    private PictureService pictureService;

    @GetMapping("")
    public ModelAndView getRoutes(ModelAndView modelAndView){

        List<ViewRoute> routes = routeService.getAllViewRoutes();
        modelAndView.addObject("routes" , routes);

        return view("routes.html" , modelAndView);

    }

    @GetMapping("/details/{id}")
    public ModelAndView getDetailAboutTheRoute(@PathVariable Long id,
                                               ModelAndView modelAndView,
                                               @AuthenticationPrincipal LoginUserDto user){

        if(user != null){
            modelAndView.addObject("userId" , user.getId());
        }

        ViewRoute route = routeService.getViewRouteById(id);
        modelAndView.addObject("route",route);
        modelAndView.addObject("routeId",id);
        modelAndView.setViewName("route-details");

        return modelAndView;

    }

    @GetMapping("/add")
    public ModelAndView getAddPage(ModelAndView modelAndView){

        modelAndView.addObject("registerRoute" , new RegisterRouteDto());
        return view("add-route.html" , modelAndView);

    }

    @PostMapping("/add")
    public ModelAndView addRoute(@Valid @ModelAttribute(name = "registerRoute")RegisterRouteDto registerRouteDto,
                                 BindingResult result,
                                 @AuthenticationPrincipal LoginUserDto loginUser,
                                 ModelAndView modelAndView) throws IOException {

        if(result.hasErrors()){
            modelAndView.addObject("registerRoute" , registerRouteDto);
            modelAndView.addObject("pictureUpload" , new UploadPictureDto());
            return view("add-route.html" , modelAndView);
        }

        routeService.saveRote(registerRouteDto , loginUser.getId());
        modelAndView.setViewName("redirect:/routes");
        return modelAndView;

    }

    @GetMapping(value = {"/pedestrian/{level}",
            "/bicycle/{level}",
            "/motorcycle/{level}",
            "/car/{level}"})
    public ModelAndView getUniqueCategorical(ModelAndView modelAndView, @PathVariable Integer level){
        modelAndView.addObject("routes" ,routeService.getAllViewRoutesByCategoryConstOriginalId(level));
        return switch (level) {
            case 1 -> view("pedestrian.html", modelAndView);
            case 2 -> view("bicycle.html", modelAndView);
            case 3 -> view("motorcycle.html", modelAndView);
            default -> view("car.html", modelAndView);
        };
    }

    @PostMapping("/picture/{routeId}/{userId}")
    public ModelAndView uploadPicture(@Valid @ModelAttribute (name = "pictureUpload") UploadPictureDto picture,
                                      ModelAndView modelAndView,
                                      @PathVariable(name = "routeId") Long routeId,
                                      @PathVariable(name = "userId") Long userId){

        modelAndView.setViewName("redirect:/routes/details/"+routeId);

       pictureService.savePicture(picture, userId, routeId);

        return modelAndView;
    }


}
