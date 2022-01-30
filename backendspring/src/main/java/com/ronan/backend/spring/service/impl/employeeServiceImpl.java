package com.ronan.backend.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ronan.backend.spring.exception.employeeNotFoundException;
import com.ronan.backend.spring.model.employee;
import com.ronan.backend.spring.repository.employeeRepository;
import com.ronan.backend.spring.service.employeeService;
import com.ronan.backend.spring.exception.employeeNotFoundException;

@Service
public class employeeServiceImpl implements employeeService{

	@Autowired
	private employeeRepository employeeRepository;

	public employeeServiceImpl(com.ronan.backend.spring.repository.employeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<employee> getAllEmployees() {
		return this.employeeRepository.findAll();
	}

	@Override
	public employee creatEmployee(employee employee) {
		return this.employeeRepository.save(employee);
	}

	@Override
	public employee updateEmployee(employee employee, long id) {
		employee employee2 = employeeRepository.findById(id).
				orElseThrow(() -> new employeeNotFoundException(String.format("UUser with ID : %d Not Found", id)));
		employee2.setFirstName(employee.getFirstName());
		employee2.setLastName(employee.getLastName());
		employee2.setEmail(employee.getEmail());
		
		return employeeRepository.save(employee2);
	}

	@Override
	public employee findEmployeeById(long id) {
		employee employee = employeeRepository.findById(id).
				orElseThrow(() -> new employeeNotFoundException(String.format("User with ID : %d Not Found", id)));
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		employee employee = employeeRepository.findById(id).
				orElseThrow(() -> new employeeNotFoundException(String.format("User with ID : %d Not Found", id)));
		employeeRepository.delete(employee);
		
	}
	
	
	
	
	
	
}
