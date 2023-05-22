package com.example.dtointro.entity.DTO;

import java.util.ArrayList;
import java.util.List;

public class ManagerDto {
    private String firstName;
    private String lastName;
    private List<EmployeeDTO> EmployeeDos;

    public ManagerDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        EmployeeDos = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<EmployeeDTO> getEmployeeDos() {
        return EmployeeDos;
    }

    public void setEmployeeDos(List<EmployeeDTO> employeeDos) {
        EmployeeDos = employeeDos;
    }
}
