package com.wellsfargo.fsd.Model;

import java.time.LocalDate;

public class Employee {
	
	private String fullName;
	private double Basic;
	
	private LocalDate hireDate;
	
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public double getBasic() {
		return Basic;
	}
	public void setBasic(double basic) {
		Basic = basic;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public double getHra() {
		return hra;
	}
	public void setHra(double hra) {
		this.hra = hra;
	}
	public double getTa() {
		return ta;
	}
	public void setTa(double ta) {
		this.ta = ta;
	}
	private double hra;
	private double ta;
	@Override
	public String toString() {
		return "Employee [fullName=" + fullName + ", Basic=" + Basic + ", hireDate=" + hireDate + ", hra=" + hra
				+ ", ta=" + ta + "]";
	}

}
