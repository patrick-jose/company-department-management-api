package com.patrick.companydepartmentmanagementapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.patrick.companydepartmentmanagementapi.model.Department;
import com.patrick.companydepartmentmanagementapi.model.DepartmentEmployee;
import com.patrick.companydepartmentmanagementapi.model.Employee;
import com.patrick.companydepartmentmanagementapi.repository.DepartmentEmployeeRepository;
import com.patrick.companydepartmentmanagementapi.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    
    private EmployeeRepository employeeRepository;
    private DepartmentEmployeeRepository departmentEmployeeRepository;

    @GetMapping
    public @ResponseBody List<Employee> list() {
        return employeeRepository.findAll();
    }

    @GetMapping
    @RequestMapping(name = "/api/employees")
    public @ResponseBody List<Optional<Employee>> listByCompanyId(@RequestParam Long departmentId) {
        var department = new Department();
        department.setId((departmentId));

        var departmentEmployee = departmentEmployeeRepository.findByDepartment(department);

        var employeeList = new ArrayList<Optional<Employee>>();

        for (DepartmentEmployee item : departmentEmployee) {
            var employee = employeeRepository.findById(item.getEmployee().getId());

            employeeList.add(employee);
        }

        return employeeList;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee, Department department) {
        var departmentEmployee = new DepartmentEmployee();

        departmentEmployee.setCreatedBy(employee.getCreatedBy());
        departmentEmployee.setCreatedDate(employee.getCreatedDate());
        departmentEmployee.setModifiedBy(employee.getModifiedBy());
        departmentEmployee.setStatus(true);
        departmentEmployee.setDepartment(department);
        departmentEmployee.setEmployee(employee);

        departmentEmployeeRepository.save(departmentEmployee);
        return employeeRepository.save(employee);
    }
}
