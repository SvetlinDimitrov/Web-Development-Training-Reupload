package com.example.validationexercise.web.controller;

import com.example.validationexercise.domain.viewMapping.ViewCompany;
import com.example.validationexercise.service.CompanyService;
import com.example.validationexercise.web.constants.DefaultModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/companies")
public class CompanyController extends DefaultModel {

    private CompanyService companyService;

    @GetMapping("/all")
    public ModelAndView getCompanies(ModelAndView modelAndView) {
        List<ViewCompany> allCompanies = companyService.getAllCompanies();
        modelAndView.addObject("allCompanies", allCompanies);
        return view("company-all", modelAndView);
    }

    @GetMapping("/add")
    public ModelAndView addCompany() {
        return view("company-add");
    }

    @PostMapping("/add")
    public ModelAndView getCompany(@Valid @ModelAttribute(name = "company") ViewCompany company,
                                   BindingResult result,
                                   ModelAndView modelAndView) {
        if (result.hasErrors()) {

            return view("company-add");
        }
        companyService.save(company);

        modelAndView.addObject("company", company);
        modelAndView.setViewName("redirect:/companies/details");

        return modelAndView;
    }

    //TODO::sameHow to get the id for the corresponding entity
    @GetMapping("/details")
    public ModelAndView getDetails(ModelAndView modelAndView) {

        return view("company-details.html", modelAndView);
    }

    @ModelAttribute(name = "company")
    public ViewCompany company() {
        return new ViewCompany();
    }

    //TODO: delete requesting

}

