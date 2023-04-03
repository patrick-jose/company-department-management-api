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
import com.patrick.companydepartmentmanagementapi.model.Department;
import com.patrick.companydepartmentmanagementapi.repository.DepartmentRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {
    
    private DepartmentRepository departmentRepository;

    @GetMapping
    public @ResponseBody List<Department> listByCompanyId(@RequestParam(required = false) Long companyId) {
        var company = new Company();
        company.setId((companyId));

        if (companyId == null || companyId == 0)
            return departmentRepository.findAll();

        return departmentRepository.findByCompany(company);
    }

    @GetMapping()
    @RequestMapping("byId")
    public @ResponseBody Optional<Department> getById(@RequestParam Long id) {
        return departmentRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Department create(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Department update(@RequestBody Department department) {
        return departmentRepository.save(department);
    }
}
