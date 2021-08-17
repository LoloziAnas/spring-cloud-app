package com.lzitech.customerservice;

import com.lzitech.customerservice.DAO.CustomerRepository;
import com.lzitech.customerservice.models.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save( new Customer(null, "Anas LLOZI","0611247551"));
			customerRepository.save( new Customer(null, "Khalid DOPAMINO","0687561275"));
			customerRepository.save( new Customer(null, "Youssef BABILON","0644889933"));
			customerRepository.findAll().forEach(System.out::println);
		};
	}
}
