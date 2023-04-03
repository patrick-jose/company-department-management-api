package com.patrick.companydepartmentmanagementapi.model;

import java.util.Date;
import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "departments_employees")
public class DepartmentEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private Date createdDate;

    @Column(length = 100)
    private String modifiedBy;

    private Date modifiedDate;

    @Column(nullable = false)
    private boolean status;

    @OneToOne
    @JoinColumn(name = "id_department")
    private Department department;

    @OneToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    public void setDepartmentOptional(Optional<Department> department) {
        if (department.isPresent())
            this.department = department.get();
    }
}
