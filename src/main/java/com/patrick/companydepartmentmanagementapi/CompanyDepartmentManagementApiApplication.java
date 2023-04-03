package com.patrick.companydepartmentmanagementapi;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.patrick.companydepartmentmanagementapi.model.Company;
import com.patrick.companydepartmentmanagementapi.model.Department;
import com.patrick.companydepartmentmanagementapi.repository.CompanyRepository;
import com.patrick.companydepartmentmanagementapi.repository.DepartmentRepository;
import com.patrick.companydepartmentmanagementapi.repository.EmployeeRepository;

@SpringBootApplication
public class CompanyDepartmentManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyDepartmentManagementApiApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CompanyRepository companyRepository, DepartmentRepository departmentRepository) {
		return args -> {
			companyRepository.deleteAll();

			Company c = new Company();
			c.setCreatedBy("Teste criação");
			c.setCreatedDate(new Date());
			c.setModifiedBy("Teste modificação");
			c.setModifiedDate(new Date());
			c.setStatus(true);
			c.setAddress("Teste endereço XPTO blá blá blá");
			c.setName("Teste Empresa XPTO");
			c.setPhone("+5521965715636");
			
			companyRepository.save(c);

			departmentRepository.deleteAll();

			Department d = new Department();
			d.setCreatedBy("Teste criação");
			d.setCreatedDate(new Date());
			d.setModifiedBy("Teste modificação");
			d.setModifiedDate(new Date());
			d.setStatus(true);
			d.setDescription("Teste descrição XPTO blá blá blá");
			d.setName("Teste Departamento XPTO");
			d.setPhone("+5521965715636");
			d.setCompany(c);
			
			departmentRepository.save(d);
		};
	}
}
