package com.Employee.EmployeeBack.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.EmployeeBack.Domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Optional<Employee> findByUuid(String uuid);
    Optional<Employee> findById(int id);
}

 
	 
 