package com.ronan.backend.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ronan.backend.spring.model.employee;

@Repository
public interface employeeRepository extends JpaRepository<employee, Long>{

	

}
