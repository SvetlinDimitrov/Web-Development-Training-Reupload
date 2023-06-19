package com.example.mobileleweb.web.controller;

import com.example.mobileleweb.service.Brand.BrandService;
import com.example.mobileleweb.web.constants.BaseModelAndView;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/brands/all")
@AllArgsConstructor
public class BrandController extends BaseModelAndView {

    private BrandService brandService;

    @GetMapping
    public ModelAndView getAllModels(ModelAndView modelAndView,
                                     HttpSession session){
        if(session.getAttribute("loggedUser") == null){
            return redirect("/users/login" , modelAndView);
        }
        modelAndView.addObject("allBrands" , brandService.getAllBrands());
        modelAndView.setViewName("brands");
        return modelAndView;
    }
}
