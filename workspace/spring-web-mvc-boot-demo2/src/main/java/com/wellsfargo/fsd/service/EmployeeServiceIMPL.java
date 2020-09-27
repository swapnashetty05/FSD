package com.wellsfargo.fsd.service;

import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.model.Employee;

@Service
public class EmployeeServiceIMPL implements EmployeeServiceInt {

	@Override
	public void computeAllowence(Employee emp) {

		emp.setTa(emp.getBasic()* 0.10);
		emp.setHra(emp.getBasic()* 0.20);
		
	}

}
