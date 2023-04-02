package com.patrick.companydepartmentmanagementapi.model;

import java.util.Date;

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
@Table(name = "departments")
public class Department {
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

    private String description;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 15)
    private String phone;

    @OneToOne
    @JoinColumn(name = "id_enterprise")
    private Company company;
}
