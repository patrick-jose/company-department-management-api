package com.patrick.companydepartmentmanagementapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patrick.companydepartmentmanagementapi.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
