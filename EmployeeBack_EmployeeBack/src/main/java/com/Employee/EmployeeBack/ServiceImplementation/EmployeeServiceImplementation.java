package com.Employee.EmployeeBack.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Employee.EmployeeBack.Dao.EmployeeRepository;
import com.Employee.EmployeeBack.Domain.Employee;
import com.Employee.EmployeeBack.Service.EmployeeService;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	
	@Autowired
	private EmployeeRepository employeerepo;

	@Override
	public void createRegistrar(Employee reg) {
		
		employeerepo.save(reg);
		
	}


	

	@Override
	public List<Employee> findAll(Class c) {
		// TODO Auto-generated method stub
		return employeerepo.findAll();
	}

	

	@Override
	public Optional<Employee> findByUuid(String uuid) {
	
		return employeerepo.findByUuid(uuid);
	}

	@Override
	public void update(Employee em) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public Optional<Employee> findByid(int id) {
		// TODO Auto-generated method stub
		return employeerepo.finByid(id);
	}*/


	@Override
	public void delete(Employee reg) {
		
		employeerepo.delete(reg);
		
	}




	@Override
	public Optional<Employee> findById(int id) {
		// TODO Auto-generated method stub
		return employeerepo.findById(id);
	}




/*	@Override
	public Optional<Employee> findByid(int id) {
		// TODO Auto-generated method stub
		return employeerepo.findById(id);
	}*/




	/*@Override
	public Employee findByid(int id) {
		// TODO Auto-generated method stub
		return employeerepo.getOne(id);
	}*/

	

}
