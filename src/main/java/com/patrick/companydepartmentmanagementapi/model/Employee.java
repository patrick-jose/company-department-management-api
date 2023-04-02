package com.patrick.companydepartmentmanagementapi.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
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

    private Long age;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 30)
    private String email;

    @Column(length = 50)
    private String position;

    @Column(length = 20)
    private String surname;
}
