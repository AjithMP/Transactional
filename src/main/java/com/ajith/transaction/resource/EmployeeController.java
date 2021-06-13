package com.ajith.transaction.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajith.transaction.service.EmployeeService;
import com.ajith.transaction.vo.EmployeeRequestVO;

@RestController
@RequestMapping
public class EmployeeController {
	
private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
	super();
	this.employeeService = employeeService;
}


	@PostMapping("/create")
	public String saveEmployee(@RequestBody EmployeeRequestVO employeeRequestVO) {
		return employeeService.saveEmployee(employeeRequestVO);
	}
}
