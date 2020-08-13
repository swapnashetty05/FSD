package com.wellsfargo.fsd.service;

import com.wellsfargo.fsd.Model.Employee;

public class EmployeeService {

	
	public void computeAll(Employee emp) {
		emp.setHra(emp.getBasic() *0.15);
		emp.setTa(emp.getBasic() *0.25);
	}
	
	
}
