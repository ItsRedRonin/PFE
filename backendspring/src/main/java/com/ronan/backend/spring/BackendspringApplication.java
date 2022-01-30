package com.ronan.backend.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ronan.backend.spring.model.employee;
import com.ronan.backend.spring.repository.employeeRepository;

@SpringBootApplication
public class BackendspringApplication implements CommandLineRunner{

	@Autowired
	private employeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BackendspringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.employeeRepository.save(new employee("yas 1", "el 1", "email 1"));
		this.employeeRepository.save(new employee("yas 2", "el 2", "email 2"));
		this.employeeRepository.save(new employee("yas 3", "el 3", "email 3"));
		this.employeeRepository.save(new employee("yas 4", "el 4", "email 4"));
	}
	
	
	

}
