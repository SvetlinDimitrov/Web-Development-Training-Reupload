package com.example.validationexercise.service;

import com.example.validationexercise.domain.entity.Company;
import com.example.validationexercise.domain.viewMapping.ViewCompany;
import com.example.validationexercise.domain.viewMapping.ViewEmployee;

import java.util.List;

public interface CompanyService {
    void save(ViewCompany company);

    List<ViewCompany> getAllCompanies();

    ViewCompany findById(String id);
    Company companyById(String id);

}
