package com.example.validationexercise.repos;

import com.example.validationexercise.domain.entity.Company;
import com.example.validationexercise.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company , String> {

}

