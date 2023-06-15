package com.example.validationexercise.web.controller;

import com.example.validationexercise.domain.viewMapping.ViewEmployee;
import com.example.validationexercise.service.EmployeeService;
import com.example.validationexercise.web.constants.DefaultModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController extends DefaultModel {

    private EmployeeService employeeService;

    @GetMapping("/all")
    public ModelAndView getCompanies() {
        return view("employee-all");
    }

    @GetMapping("/add")
    public ModelAndView addCompany(ViewEmployee viewEmployee ,
                                   ModelAndView modelAndView) {

        return view("employee-add");
    }

    @GetMapping("/details")
    public ModelAndView details(){
        return view("employee-details.html");
    }
}
