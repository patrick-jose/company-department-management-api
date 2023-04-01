package com.patrick.companydepartmentmanagementapi.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrick.companydepartmentmanagementapi.model.Company;
import com.patrick.companydepartmentmanagementapi.repository.CompanyRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/companies")
@AllArgsConstructor
public class CompanyController {
    
    private CompanyRepository companyRepository;

    @GetMapping
    public List<Company> list() {
        return companyRepository.findAll();
    }
}
