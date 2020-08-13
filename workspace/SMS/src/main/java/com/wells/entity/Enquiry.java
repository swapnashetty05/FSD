package com.wells.entity;


public class Enquiry {

	private Integer enquiryId;
	private String customerName;
	private  String vehicleType;
	private Integer mobile;
	private String  status;
	private Double budgetFrom;
	private Double budgetTo;
	
	
	public Enquiry(Integer enquiryId, String customerName, String vehicleType, Integer mobile, String status,
			Double budgetFrom, Double budgetTo) {
		super();
		this.enquiryId = enquiryId;
		this.customerName = customerName;
		this.vehicleType = vehicleType;
		this.mobile = mobile;
		this.status = status;
		this.budgetFrom = budgetFrom;
		this.budgetTo = budgetTo;
	}


	public Integer getEnquiryId() {
		return enquiryId;
	}


	public void setEnquiryId(Integer enquiryId) {
		this.enquiryId = enquiryId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}


	public Integer getMobile() {
		return mobile;
	}


	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Double getBudgetFrom() {
		return budgetFrom;
	}


	public void setBudgetFrom(Double budgetFrom) {
		this.budgetFrom = budgetFrom;
	}


	public Double getBudgetTo() {
		return budgetTo;
	}


	public void setBudgetTo(Double budgetTo) {
		this.budgetTo = budgetTo;
	}


	@Override
	public String toString() {
		return "Enquiry [enquiryId=" + enquiryId + ", customerName=" + customerName + ", vehicleType=" + vehicleType
				+ ", mobile=" + mobile + ", status=" + status + ", budgetFrom=" + budgetFrom + ", budgetTo=" + budgetTo
				+ "]";
	}
	
	
	
}
