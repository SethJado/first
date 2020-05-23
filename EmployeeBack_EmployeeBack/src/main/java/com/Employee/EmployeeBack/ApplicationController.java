package com.Employee.EmployeeBack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ApplicationController {

	
	@RequestMapping("/save")
	public String login() {
		return "index.html";
	}
	
	@RequestMapping("/data")
	public String save() {
		return "emp.html";
	}
}
