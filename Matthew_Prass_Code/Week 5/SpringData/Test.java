package com.ex.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bank.pojos.Employee;
import com.bank.util.EmployeeRepository;

@SpringBootApplication
public class Test {
	
	private static final Logger log = LoggerFactory.getLogger(Test.class);


	public static void main(String[] args) {
		SpringApplication.run(Test.class);
	}
	
	@Bean
	public CommandLineRunner demo(EmployeeRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Employee("Jack", "Bauer"));
			repository.save(new Employee("Chloe", "O'Brian"));
			repository.save(new Employee("Kim", "Bauer"));
			repository.save(new Employee("David", "Palmer"));
			repository.save(new Employee("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Employee customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Employee customer = repository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (Employee bauer : repository.findByLastName("Bauer")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}

}
