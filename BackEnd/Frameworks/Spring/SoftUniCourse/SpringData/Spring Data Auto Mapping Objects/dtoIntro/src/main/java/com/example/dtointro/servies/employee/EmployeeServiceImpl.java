package com.example.dtointro.servies.employee;

import com.example.dtointro.Repos.EmployeeRepo;
import com.example.dtointro.entity.DTO.EmployeeDTO;
import com.example.dtointro.entity.DTO.ManagerDto;
import com.example.dtointro.entity.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public void registerUsers(ManagerDto managerDto) {
        ModelMapper mapper = new ModelMapper();
        Employee manager = mapper.map(managerDto, Employee.class);

        for (int i = 0; i < managerDto.getEmployeeDos().size(); i++) {
            EmployeeDTO employeeDTO = managerDto.getEmployeeDos().get(i);
            Employee employee = mapper.map(employeeDTO, Employee.class);
            employee.setManager(manager);
            manager.getWorkers().add(employee);
        }

        employeeRepo.save(manager);
    }
}
