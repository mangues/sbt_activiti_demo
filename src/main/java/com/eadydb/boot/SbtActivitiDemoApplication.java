package com.eadydb.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.eadydb.boot.entity.Company;
import com.eadydb.boot.entity.Person;
import com.eadydb.boot.repository.CompanyRepository;
import com.eadydb.boot.repository.PersonRepository;
import com.eadydb.boot.service.ActivitiService;

@SpringBootApplication
public class SbtActivitiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbtActivitiDemoApplication.class, args);
	}

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private CompanyRepository companyRepository;

	// 初始化模拟数据
	@Bean
	public CommandLineRunner init(final ActivitiService activitiService) {
		return new CommandLineRunner() {

			@Override
			public void run(String... arg0) throws Exception {
				if (personRepository.findAll().size() == 0) {
					personRepository.save(new Person("admin"));
					personRepository.save(new Person("db2"));
					personRepository.save(new Person("eadydb"));
				}
				if (companyRepository.findAll().size() == 0) {
					Company company = new Company("gdSouthSoft");
					companyRepository.save(company);
					Person admin = personRepository.findByPersonName("admin");
					admin.setCompany(company);
					personRepository.save(admin);
					Person db = personRepository.findByPersonName("db2");
					db.setCompany(company);
					personRepository.save(db);
				}
			}
		};
	}
}
