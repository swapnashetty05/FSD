package com.wellsfargo.fsd.Model;

public class Loan {
	
	private double principle;
	private double rateOfInterest;
	private int emiCount;
	private double emi;
	
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	public double getPrinciple() {
		return principle;
	}
	public void setPrinciple(double principle) {
		this.principle = principle;
	}
	public double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public int getEmiCount() {
		return emiCount;
	}
	public void setEmiCount(int emiCount) {
		this.emiCount = emiCount;
	}

}
