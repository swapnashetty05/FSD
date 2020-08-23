package com.wellsfargo.corona.entity;

public class KitDetail {

	private int id;
	private int ppid;
	private int productId;
	private String productName;
	private int quantity;
	private double amount;
	
	public KitDetail() {
		super();
	}
	
	
	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public KitDetail(int id, int ppid, int productId, String productName, int quantity, double amount) {
		super();
		this.id = id;
		this.ppid = ppid;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.amount = amount;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPpid() {
		return ppid;
	}
	public void setPpid(int ppid) {
		this.ppid = ppid;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double d) {
		this.amount = d;
	}
}
