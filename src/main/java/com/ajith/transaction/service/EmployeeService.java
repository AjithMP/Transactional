package com.ajith.transaction.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajith.transaction.domain.Department;
import com.ajith.transaction.domain.Employee;
import com.ajith.transaction.repository.DepartmentRepository;
import com.ajith.transaction.repository.EmployeRepository;
import com.ajith.transaction.vo.EmployeeRequestVO;

@Service

public class EmployeeService {

private EmployeRepository employeeRepository;
private DepartmentRepository departmentRepository;
    @Autowired  
	public EmployeeService(EmployeRepository employeeRepository, DepartmentRepository departmentRepository) {
	
	this.employeeRepository = employeeRepository;
	this.departmentRepository= departmentRepository;
} 
    @Transactional
	public String saveEmployee(EmployeeRequestVO employeeRequestVO) {
		
		Department department = new Department();
		department.setDepartmentName(employeeRequestVO.getDepartmentName());
		department.setDepartmentCode(employeeRequestVO.getDepartmentName());
		Long departmentID= departmentRepository.save(department)
				   .getDepartmentId();
		Employee employee = new Employee();
		employee.setEmail(employeeRequestVO.getEmail());
		employee.setDepartmentId(departmentID);
		employee.setEmpName(employeeRequestVO.getEmpName());
        employeeRepository.save(employee);
        return "Employee Created successfully";
	}

}
