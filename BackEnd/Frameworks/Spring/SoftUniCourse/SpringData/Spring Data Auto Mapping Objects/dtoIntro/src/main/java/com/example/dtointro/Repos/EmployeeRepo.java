package com.example.dtointro.Repos;

import com.example.dtointro.entity.DTO.EmployeeDTO;
import com.example.dtointro.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo  extends JpaRepository<Employee , Long> {
    Employee findByFirstNameAndLastName(String firstName , String lastName);
}
