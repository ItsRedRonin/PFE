package com.ronan.backend.spring.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ronan.backend.spring.model.employee;

public interface employeeService {

	List<employee> getAllEmployees();

	employee creatEmployee(employee employee);

	employee updateEmployee(employee employee, long id);

	employee findEmployeeById(long id);

	void deleteEmployeeById(long id);

}
