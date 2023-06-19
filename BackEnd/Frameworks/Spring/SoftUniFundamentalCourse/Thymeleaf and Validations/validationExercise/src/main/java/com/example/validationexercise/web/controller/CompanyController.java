package com.example.validationexercise.web.controller;

import com.example.validationexercise.domain.entity.Company;
import com.example.validationexercise.domain.viewMapping.ViewCompany;
import com.example.validationexercise.service.CompanyService;
import com.example.validationexercise.web.constants.DefaultModel;
import jakarta.servlet.http.HttpSession;
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
    public ModelAndView addCompany(@ModelAttribute(name = "company") ViewCompany company) {
        return view("company-add");
    }

    @PostMapping("/add")
    public ModelAndView getCompany(@Valid @ModelAttribute(name = "company") ViewCompany company,
                                   BindingResult result,
                                   HttpSession session) {
        if (result.hasErrors()) {
            return view("company-add");
        }

        ViewCompany savedCompany = companyService.save(company);

        session.setAttribute("company", savedCompany);
        return redirect(String.format("/companies/details/%s",savedCompany.getId()), new ModelAndView());
    }

    //TODO::sameHow to get the id for the corresponding entity
    @GetMapping("/details/{id}")
    public ModelAndView getDetails(@PathVariable(name = "id") String id,
                                   ModelAndView modelAndView) {

        ViewCompany company = companyService.companyById(id);
        modelAndView.addObject("company", company);
        return view("company-details.html", modelAndView);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteCompany(@PathVariable(name = "id") String id) {

        companyService.deleteCompany(id);

        return redirect("/companies/all", new ModelAndView());
    }

}

