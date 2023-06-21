
package com.example.validationexercise.service;

import com.example.validationexercise.domain.viewMapping.ViewEmployee;

import java.util.List;

public interface EmployeeService {
    ViewEmployee save(ViewEmployee employee);

    List<ViewEmployee> getAllEmployees();

    ViewEmployee findEmployeeById(String id);

    void deleteEmployee(String id);
}
