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
			c.setCreatedBy("Patrick");
			c.setCreatedDate(new Date());
			c.setModifiedBy("Patrick");
			c.setModifiedDate(new Date());
			c.setStatus(true);
			c.setAddress("Rua Leblon\nLeblon\nRio de Janeiro\nRJ");
			c.setName("Empresa XPTO 1");
			c.setPhone("+5521965715636");
			
			companyRepository.save(c);

			Company c2 = new Company();
			c2.setCreatedBy("Patrick");
			c2.setCreatedDate(new Date());
			c2.setModifiedBy("Patrick");
			c2.setModifiedDate(new Date());
			c2.setStatus(true);
			c2.setAddress("Avenida Hermes Monteiro da Silva\nNovo Horizonte\nMacapá\nAP");
			c2.setName("Empresa XPTO 2");
			c2.setPhone("+5521965715637");
			
			companyRepository.save(c2);

			Company c3 = new Company();
			c3.setCreatedBy("Patrick");
			c3.setCreatedDate(new Date());
			c3.setModifiedBy("Patrick");
			c3.setModifiedDate(new Date());
			c3.setStatus(true);
			c3.setAddress("Rua Miguel Carneiro\nParque Veiga Jardim\nAparecida de Goiânia\nGO");
			c3.setName("Empresa XPTO 3");
			c3.setPhone("+5521965715638");
			
			companyRepository.save(c3);

			Company c4 = new Company();
			c4.setCreatedBy("Patrick");
			c4.setCreatedDate(new Date());
			c4.setModifiedBy("Patrick");
			c4.setModifiedDate(new Date());
			c4.setStatus(true);
			c4.setAddress("Rua Assad Abdala\nNeves\nSão Gonçalo\nRJ");
			c4.setName("Empresa XPTO 4");
			c4.setPhone("+5521965715639");
			
			companyRepository.save(c4);

			departmentRepository.deleteAll();

			Department d = new Department();
			d.setCreatedBy("Departamento 1");
			d.setCreatedDate(new Date());
			d.setModifiedBy("Patrick");
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
