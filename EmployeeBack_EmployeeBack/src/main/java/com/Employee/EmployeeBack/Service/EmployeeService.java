package com.Employee.EmployeeBack.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.Employee.EmployeeBack.Dao.EmployeeRepository;
import com.Employee.EmployeeBack.Domain.Employee;

public interface EmployeeService {
  
	
	
	public void createRegistrar(Employee reg);
	public void delete(Employee reg);
	public void update(Employee em);
	public Optional<Employee> findById(int id);
	public List<Employee> findAll(Class c);
	public  Optional<Employee> findByUuid(String uuid);
	
	
	}
	
	

