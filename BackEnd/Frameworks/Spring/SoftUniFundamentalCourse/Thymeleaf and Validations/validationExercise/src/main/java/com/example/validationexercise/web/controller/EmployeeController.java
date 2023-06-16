package com.example.validationexercise.web.controller;

import com.example.validationexercise.domain.viewMapping.ViewCompany;
import com.example.validationexercise.domain.viewMapping.ViewEmployee;
import com.example.validationexercise.service.CompanyService;
import com.example.validationexercise.service.EmployeeService;
import com.example.validationexercise.web.constants.DefaultModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController extends DefaultModel {

    private EmployeeService employeeService;
    private CompanyService companyService;

    @GetMapping("/all")
    public ModelAndView getCompanies(ModelAndView modelAndView) {
        return view("employee-all" , modelAndView);
    }

    @GetMapping("/add")
    public ModelAndView addMenuForEmployees() {
        return view("employee-add");
    }

    @PostMapping("/add")
    public ModelAndView addEmployee(@Valid ViewEmployee employee,
                                    BindingResult bindingResult,
                                    ModelAndView modelAndView) {

        if(bindingResult.hasErrors()){
            modelAndView.addObject("employee",employee);
            return view("employee-add",modelAndView);
        }

        ViewEmployee saved = employeeService.save(employee);
        modelAndView.addObject("employee" , saved);

        return redirect("/employees/details" , modelAndView);
    }

    //TODO::sameHow to get the id for the corresponding entity
    @GetMapping("/details")
    public ModelAndView details(){
        return view("employee-details.html");
    }

    @ModelAttribute(name = "employee")
    public ViewEmployee employee(){
        return new ViewEmployee();
    }

    @ModelAttribute(name = "allCompanies")
    public List<ViewCompany> allCompanies(){
        return companyService.getAllCompanies();
    }

    @ModelAttribute(name = "allEmployees")
    public List<ViewEmployee> allEmployees(){
        return employeeService.getAllEmployees();
    }
    //TODO: delete requesting
}
