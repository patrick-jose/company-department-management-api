package com.patrick.companydepartmentmanagementapi.controller.DTO;

import java.util.Date;

import com.patrick.companydepartmentmanagementapi.model.Department;
import com.patrick.companydepartmentmanagementapi.model.DepartmentEmployee;
import com.patrick.companydepartmentmanagementapi.model.Employee;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class DepartmentEmployeeDTO {
    private Long id;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private boolean status;
    private Long idDepartment;
    private Long idEmployee;
    public boolean getStatus() {
        return this.status;
    }
}
