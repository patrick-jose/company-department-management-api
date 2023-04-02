package com.patrick.companydepartmentmanagementapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patrick.companydepartmentmanagementapi.model.Department;
import com.patrick.companydepartmentmanagementapi.model.DepartmentEmployee;

@Repository
public interface DepartmentEmployeeRepository extends JpaRepository<DepartmentEmployee, Long> {
    
    List<DepartmentEmployee> findByDepartment(Department department);

}
