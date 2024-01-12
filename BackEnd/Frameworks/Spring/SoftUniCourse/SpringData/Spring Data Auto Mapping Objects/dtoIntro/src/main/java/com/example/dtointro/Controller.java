package com.example.dtointro;

import com.example.dtointro.entity.DTO.EmployeeDTO;
import com.example.dtointro.entity.DTO.ManagerDto;
import com.example.dtointro.servies.employee.EmployeeService;
import com.example.dtointro.servies.employee.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import java.util.Scanner;

@Component
public class Controller implements CommandLineRunner {
    EmployeeService employeeService;

    @Autowired
    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String [] s = scanner.nextLine().split(" \\| ");
        String firstNameManager = s[0].split(" ")[0];
        String lastNameManager = s[0].split(" ")[1];
        ManagerDto managerDto = new ManagerDto(firstNameManager , lastNameManager);

        int numberOfEmployees = Integer.parseInt(s[1].split(": ")[1]);
        for (int i = 0; i < numberOfEmployees; i++) {
            String input = scanner.nextLine().trim();
            String firstNameEmployee = input.split(" ")[1];
            String lastNameEmployee = input.split(" ")[2];
            BigDecimal salary = BigDecimal.valueOf(Double.parseDouble(input.split(" ")[3]));

            EmployeeDTO employeeDTO = new EmployeeDTO(firstNameEmployee , lastNameEmployee , salary);
            managerDto.getEmployeeDos().add(employeeDTO);
        }
        employeeService.registerUsers(managerDto);
    }
}
