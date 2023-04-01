package com.patrick.companydepartmentmanagementapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patrick.companydepartmentmanagementapi.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    
}
