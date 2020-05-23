package com.Employee.EmployeeBack.Controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Employee.EmployeeBack.Domain.Employee;
import com.Employee.EmployeeBack.Service.EmployeeService;
import com.Employee.EmployeeBack.Utility.Messages;
import com.Employee.EmployeeBack.Utility.ResponseBean;

@RestController
@CrossOrigin
@RequestMapping(value="/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;
	
	
	@CrossOrigin
	@RequestMapping(value="/save" ,method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
      public ResponseEntity<Object>createEmployee(HttpServletRequest request,@RequestBody Employee emp){
    	  
    	  ResponseBean rb= new ResponseBean();
    	  
    	  try {
    		  employeeservice.createRegistrar(emp);
    		  rb.setCode(Messages.SUCCESS_CODE);
    		  rb.setDescription(Messages.save);
    		  rb.setObject(emp);
    		  
    		  
    	  }catch(Exception e){
    		  rb.setCode(Messages.ERROR_CODE);
    		  rb.setDescription("failed to register");
    		  rb.setObject(emp);
    	  }
    	  
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
    	  
      }
	 
	@CrossOrigin
	@RequestMapping(value= "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findAllEmployee(){
		ResponseBean rb = new ResponseBean();
		try {

					List<Employee> list = employeeservice.findAll(Employee.class);
					rb.setCode(Messages.SUCCESS_CODE);
					rb.setDescription("Employees are successfully retrieved");
					rb.setObject(list);


		} catch (Exception e) {
			rb.setCode(Messages.ERROR_CODE);
			rb.setDescription("error on Employees");
		}

		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value="/emp/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findOne(HttpServletRequest request, @PathVariable String uuid) {

		ResponseBean rb = new ResponseBean();
		try {
                    Employee th= new Employee();
					Optional<Employee> emp = employeeservice.findByUuid(uuid);
					if (emp == null) {
						rb.setCode(Messages.NULLS_FOUND);
						rb.setDescription("employee not found");
					} else {
						rb.setCode(Messages.SUCCESS_CODE);
						rb.setDescription(" employee  found");
						rb.setObject(emp);
					}

		} catch (Exception e) {
			rb.setCode(Messages.ERROR_CODE);
			rb.setDescription("error occured please try again!!");
		    
		}

		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	
}
	@CrossOrigin
	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
	public ResponseEntity<Object> delete(HttpServletRequest request,@PathVariable int id) {
	        
			ResponseBean rb = new ResponseBean();
			try {
                        
					Optional<Employee> emp = employeeservice.findById(id);
						Employee mm = emp.get();
						if (mm == null) {
							rb.setCode(Messages.NOT_FOUND);
							rb.setDescription("The employee was not deleted");
						} else {

							employeeservice.delete(mm);
							rb.setCode(Messages.SUCCESS_CODE);
							rb.setDescription("registrar Deleted ");
							rb.setObject(mm);
						}

					
			} catch (Exception e) {
				rb.setCode(Messages.ERROR_CODE);
				rb.setDescription("employee not deleted");
			}
			return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
    @CrossOrigin
	@RequestMapping(method=RequestMethod.PUT, value = "/update/{uuid}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updated(HttpServletRequest request, @PathVariable String uuid, @RequestBody Employee emp) {
	        
			ResponseBean rb = new ResponseBean();
			
			try {
				Optional<Employee> em = employeeservice.findByUuid(uuid);
				Employee emm = em.get();
				emm.setFirstname(emp.getFirstname());
				emm.setLastname(emp.getLastname());
				emm.setDob(emp.getDob());
				emm.setSalary(emp.getSalary());
				emm.setGender(emp.getGender());
				employeeservice.update(emm);
				rb.setCode(Messages.SUCCESS_CODE);
				rb.setDescription("employee well updated");
				rb.setObject(emm);
			}catch(Exception ex) {
				rb.setCode(Messages.ERROR_CODE);
				rb.setDescription("Employee failed Updated");
			}
			
			return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
    
  
  
}

