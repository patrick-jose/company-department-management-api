package com.patrick.companydepartmentmanagementapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.patrick.companydepartmentmanagementapi.model.Company;
import com.patrick.companydepartmentmanagementapi.repository.CompanyRepository;

import ch.qos.logback.core.joran.conditional.ElseAction;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/companies")
@AllArgsConstructor
public class CompanyController {
    
    private CompanyRepository companyRepository;

    @GetMapping
    public @ResponseBody List<Company> list() {
        return companyRepository.findAll();
    }

    @GetMapping()
    @RequestMapping("byId")
    public @ResponseBody Optional<Company> getById(@RequestParam Long id) {
        return companyRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Company create(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Company update(@RequestBody Company company) {
        return companyRepository.save(company);
    }
}
