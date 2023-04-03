package com.patrick.companydepartmentmanagementapi.controller.DTO;

import com.patrick.companydepartmentmanagementapi.model.Department;
import com.patrick.companydepartmentmanagementapi.model.Employee;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class NewEmployeeDTO {
    private Employee employee;
    private Department department;
}
