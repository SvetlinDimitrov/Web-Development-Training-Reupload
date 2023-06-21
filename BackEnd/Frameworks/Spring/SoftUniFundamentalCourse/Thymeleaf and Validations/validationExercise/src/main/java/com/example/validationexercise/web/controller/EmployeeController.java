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
import org.springframework.web.bind.annotation.*;
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

        List<ViewEmployee> allEmployees = employeeService.getAllEmployees();
        modelAndView.addObject("allEmployees" , allEmployees);

        return view("employee-all" , modelAndView);
    }

    @GetMapping("/add")
    public ModelAndView addMenuForEmployees(ModelAndView modelAndView) {
        modelAndView.addObject("employee" , new ViewEmployee());
        modelAndView.addObject("allCompanies" , companyService.getAllCompanies());
        return view("employee-add",modelAndView);
    }

    @PostMapping("/add")
    public ModelAndView addEmployee(@Valid @ModelAttribute(name = "employee") ViewEmployee employee,
                                    BindingResult bindingResult,
                                    ModelAndView modelAndView) {

        if(bindingResult.hasErrors()){
            modelAndView.addObject("employee" , employee);
            modelAndView.addObject("allCompanies" , companyService.getAllCompanies());
            return view("employee-add",modelAndView);
        }

        ViewEmployee saved = employeeService.save(employee);

        return redirect(String.format("/employees/details/%s",saved.getId()) , new ModelAndView());
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable(name = "id") String id,
                                ModelAndView modelAndView){

        ViewEmployee employee = employeeService.findEmployeeById(id);
        modelAndView.addObject("employee" , employee);
        return view("employee-details.html" , modelAndView);

    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteEmployee(@PathVariable(name = "id") String id){

        employeeService.deleteEmployee(id);

        return redirect("/employees/all" , new ModelAndView());

    }
}
