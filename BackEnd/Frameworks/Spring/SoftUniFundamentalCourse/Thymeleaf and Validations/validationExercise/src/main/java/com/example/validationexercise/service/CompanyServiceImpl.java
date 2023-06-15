package com.example.validationexercise.service;

import com.example.validationexercise.domain.entity.Company;
import com.example.validationexercise.domain.viewMapping.ViewCompany;
import com.example.validationexercise.repos.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    @Override
    public void save(ViewCompany company) {
        companyRepository.save(company.toCompany());
    }

    @Override
    public List<ViewCompany> getAllCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(Company::toViewCompany)
                .toList();
    }

    @Override
    public ViewCompany findById(String id) {
        return companyRepository.findById(id)
                .get()
                .toViewCompany();
    }
}
