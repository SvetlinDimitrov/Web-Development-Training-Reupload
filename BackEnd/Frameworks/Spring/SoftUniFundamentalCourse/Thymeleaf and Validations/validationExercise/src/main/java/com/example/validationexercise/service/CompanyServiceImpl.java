package com.example.validationexercise.service;

import com.example.validationexercise.domain.entity.Company;
import com.example.validationexercise.domain.entity.Employee;
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
    public ViewCompany save(ViewCompany company) {
        Company save = companyRepository.save(company.toCompany());
        return save.toViewCompany();
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

    @Override
    public ViewCompany companyById(String id) {
        return companyRepository.findById(id).get().toViewCompany();
    }

    @Override
    public boolean isAlreadyExists(String name) {
        return companyRepository.findAll()
                .stream()
                .anyMatch(c->c.getName().equals(name));
    }

    @Override
    public void deleteCompany(String id) {
        Company company = companyRepository.findById(id).get();
        List<Employee> employees = company.getEmployees();
        employees.forEach(e-> e.setCompany(null));
        companyRepository.deleteById(id);
    }
}
