package com.ronan.backend.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronan.backend.spring.model.employee;
import com.ronan.backend.spring.service.employeeService;

@CrossOrigin
@RestController
@RequestMapping("/manager/")
public class employeeController {
	
	@Autowired
	private employeeService employeeService;

	public employeeController(com.ronan.backend.spring.service.employeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("all")
	public List<employee> getAllEmployees(){
		return this.employeeService.getAllEmployees();
	}
	
	@PostMapping("save")
	public employee creatEmployee(@RequestBody employee employee) {
		return this.employeeService.creatEmployee(employee);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<employee> updateEmployee(@RequestBody  employee employee,@PathVariable("id") long id) {
		return ResponseEntity.ok(employeeService.updateEmployee(employee, id));	
	}
	
	@GetMapping("find/{id}")
	public employee findEmployeeById(@PathVariable("id") long id) {
		return employeeService.findEmployeeById(id);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteEmployeeById(@PathVariable long id) {
		employeeService.deleteEmployeeById(id);
	}

}
