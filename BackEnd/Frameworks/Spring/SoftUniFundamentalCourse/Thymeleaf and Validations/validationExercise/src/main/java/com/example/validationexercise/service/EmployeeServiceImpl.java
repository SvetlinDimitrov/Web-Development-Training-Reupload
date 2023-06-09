package com.example.validationexercise.service;


import com.example.validationexercise.domain.entity.Employee;
import com.example.validationexercise.domain.viewMapping.ViewEmployee;
import com.example.validationexercise.repos.CompanyRepository;
import com.example.validationexercise.repos.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private CompanyRepository companyRepository;
    private CompanyService companyService;

    @Override
    public ViewEmployee save(ViewEmployee employee) {

        Employee employeeToSave = employee.toEmployee();
        employeeToSave.setCompany(companyRepository.findById(employee.getCompanyId()).get());

        employeeRepository.save(employeeToSave);
        return employeeToSave.toViewEmployee();
    }

    @Override
    public List<ViewEmployee> getAllEmployees(){
        return employeeRepository.findAll()
                .stream()
                .map(Employee::toViewEmployee)
                .toList();
    }

    @Override
    public ViewEmployee findEmployeeById(String id) {
        return employeeRepository.findById(id).get().toViewEmployee();
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.delete(employeeRepository.findById(id).get());
    }
}
