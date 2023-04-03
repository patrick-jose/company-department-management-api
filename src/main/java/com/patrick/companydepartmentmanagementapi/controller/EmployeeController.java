package com.patrick.companydepartmentmanagementapi.controller;

import java.util.ArrayList;
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

import com.patrick.companydepartmentmanagementapi.controller.DTO.DepartmentEmployeeDTO;
import com.patrick.companydepartmentmanagementapi.controller.DTO.NewEmployeeDTO;
import com.patrick.companydepartmentmanagementapi.model.Department;
import com.patrick.companydepartmentmanagementapi.model.DepartmentEmployee;
import com.patrick.companydepartmentmanagementapi.model.Employee;
import com.patrick.companydepartmentmanagementapi.repository.DepartmentEmployeeRepository;
import com.patrick.companydepartmentmanagementapi.repository.DepartmentRepository;
import com.patrick.companydepartmentmanagementapi.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    
    private EmployeeRepository employeeRepository;
    private DepartmentEmployeeRepository departmentEmployeeRepository;
    private DepartmentRepository departmentRepository;

    @GetMapping
    public @ResponseBody List<Employee> listByDepartmentId(@RequestParam(required = false) Long departmentId) {
        var department = new Department();
        department.setId((departmentId));

        if (departmentId == null || departmentId == 0)
            return employeeRepository.findAll();

        var departmentEmployee = departmentEmployeeRepository.findByDepartment(department);

        var employeeList = new ArrayList<Employee>();

        for (DepartmentEmployee item : departmentEmployee) {
            var employee = employeeRepository.findById(item.getEmployee().getId());

            if (employee.isPresent())
                employeeList.add(employee.get());
        }

        return employeeList;
    }

    @GetMapping()
    @RequestMapping("byId")
    public @ResponseBody Optional<Employee> getById(@RequestParam Long id) {
        return employeeRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Employee create(@RequestBody NewEmployeeDTO employee) {
        var departmentEmployee = new DepartmentEmployee();

        departmentEmployee.setCreatedBy(employee.getEmployee().getCreatedBy());
        departmentEmployee.setCreatedDate(employee.getEmployee().getCreatedDate());
        departmentEmployee.setModifiedBy(employee.getEmployee().getModifiedBy());
        departmentEmployee.setModifiedDate(employee.getEmployee().getModifiedDate());
        departmentEmployee.setStatus(true);
        departmentEmployee.setDepartment(employee.getDepartment());
        departmentEmployee.setEmployee(employee.getEmployee());

        var newEmployeeResult = employeeRepository.save(employee.getEmployee());

        departmentEmployee.setEmployee(newEmployeeResult);
        
        if (newEmployeeResult != null)
            departmentEmployeeRepository.save(departmentEmployee);
        
        return newEmployeeResult;
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Employee update(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("department")
    @ResponseStatus(code = HttpStatus.OK)
    public DepartmentEmployee updateDepartmentEmployee(@RequestBody DepartmentEmployeeDTO departmentEmployee) {
        var employee = employeeRepository.findById(departmentEmployee.getIdEmployee());
        var department = departmentRepository.findById(departmentEmployee.getIdDepartment());
        var item = departmentEmployeeRepository.findByEmployee(employee);

        item.setModifiedBy(departmentEmployee.getModifiedBy());
        item.setDepartmentOptional(department);
        item.setModifiedDate(departmentEmployee.getModifiedDate());
        item.setStatus(departmentEmployee.getStatus());

        return departmentEmployeeRepository.save(item);
    }
}
