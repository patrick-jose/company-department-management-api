package com.patrick.companydepartmentmanagementapi;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.patrick.companydepartmentmanagementapi.model.Company;
import com.patrick.companydepartmentmanagementapi.repository.CompanyRepository;

@SpringBootApplication
public class CompanyDepartmentManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyDepartmentManagementApiApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CompanyRepository companyRepository) {
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
		};
	}
}
