package com.wellsfargo.corona.entity;


public class Product {
	
	int pproductId;
	String pproductName;
	String pdescription;
	double pcost;
	String pavailabilityStatus;
	int quantity;
	
	
	public Product(int pproductId, String pproductName, String pdescription, double pcost, String pavailabilityStatus,
			int quantity) {
		super();
		this.pproductId = pproductId;
		this.pproductName = pproductName;
		this.pdescription = pdescription;
		this.pcost = pcost;
		this.pavailabilityStatus = pavailabilityStatus;
		this.quantity = quantity;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Product() {
		super();
	}


	public int getPproductId() {
		return pproductId;
	}


	public void setPproductId(int pproductId) {
		this.pproductId = pproductId;
	}


	public String getPproductName() {
		return pproductName;
	}


	public void setPproductName(String pproductName) {
		this.pproductName = pproductName;
	}


	public String getPdescription() {
		return pdescription;
	}


	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}


	public double getPcost() {
		return pcost;
	}


	public void setPcost(double pcost) {
		this.pcost = pcost;
	}


	public String getPavailabilityStatus() {
		return pavailabilityStatus;
	}


	public void setPavailabilityStatus(String pavailabilityStatus) {
		this.pavailabilityStatus = pavailabilityStatus;
	}


	public Product(int pproductId, String pproductName, String pdescription, double pcost, String pavailabilityStatus) {
		super();
		this.pproductId = pproductId;
		this.pproductName = pproductName;
		this.pdescription = pdescription;
		this.pcost = pcost;
		this.pavailabilityStatus = pavailabilityStatus;
	}


	@Override
	public String toString() {
		return "Product [pproductId=" + pproductId + ", pproductName=" + pproductName + ", pdescription=" + pdescription
				+ ", pcost=" + pcost + ", pavailabilityStatus=" + pavailabilityStatus + "]";
	}
	
	
	

}
