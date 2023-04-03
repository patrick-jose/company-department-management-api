package com.patrick.companydepartmentmanagementapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patrick.companydepartmentmanagementapi.model.Department;
import com.patrick.companydepartmentmanagementapi.model.DepartmentEmployee;
import com.patrick.companydepartmentmanagementapi.model.Employee;

@Repository
public interface DepartmentEmployeeRepository extends JpaRepository<DepartmentEmployee, Long> {
    
    List<DepartmentEmployee> findByDepartment(Department department);
    DepartmentEmployee findByEmployee(Employee employee);
    DepartmentEmployee findByEmployee(Optional<Employee> employee);
}
