package com.wellsfargo.corona.entity;

import java.time.LocalDate;

public class User {

	private int ppid;
	private String ppersonName;
	private String pemail;
	private String pcontactNumber;
	private int ptotalAmount;
	private String pdeliveryAddress;
	private LocalDate porderDate;
	private boolean porderFinalized;
	
	
	public int getPpid() {
		return ppid;
	}
	public void setPpid(int ppid) {
		this.ppid = ppid;
	}
	public String getPpersonName() {
		return ppersonName;
	}
	public void setPpersonName(String ppersonName) {
		this.ppersonName = ppersonName;
	}
	public String getPemail() {
		return pemail;
	}
	public void setPemail(String pemail) {
		this.pemail = pemail;
	}
	public String getPcontactNumber() {
		return pcontactNumber;
	}
	public void setPcontactNumber(String pcontactNumber) {
		this.pcontactNumber = pcontactNumber;
	}
	public int getPtotalAmount() {
		return ptotalAmount;
	}
	public void setPtotalAmount(int ptotalAmount) {
		this.ptotalAmount = ptotalAmount;
	}
	public String getPdeliveryAddress() {
		return pdeliveryAddress;
	}
	public void setPdeliveryAddress(String pdeliveryAddress) {
		this.pdeliveryAddress = pdeliveryAddress;
	}
	public LocalDate getPorderDate() {
		return porderDate;
	}
	public void setPorderDate(LocalDate porderDate) {
		this.porderDate = porderDate;
	}
	public boolean isPorderFinalized() {
		return porderFinalized;
	}
	public void setPorderFinalized(boolean porderFinalized) {
		this.porderFinalized = porderFinalized;
	}
	public User(int ppid, String ppersonName, String pemail, String pcontactNumber) {
		super();
		this.ppid = ppid;
		this.ppersonName = ppersonName;
		this.pemail = pemail;
		this.pcontactNumber = pcontactNumber;
	}
	public User(int ppid, String ppersonName, String pemail, String pcontactNumber, int ptotalAmount,
			String pdeliveryAddress, LocalDate porderDate, boolean porderFinalized) {
		super();
		this.ppid = ppid;
		this.ppersonName = ppersonName;
		this.pemail = pemail;
		this.pcontactNumber = pcontactNumber;
		this.ptotalAmount = ptotalAmount;
		this.pdeliveryAddress = pdeliveryAddress;
		this.porderDate = porderDate;
		this.porderFinalized = porderFinalized;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [ppid=" + ppid + ", ppersonName=" + ppersonName + ", pemail=" + pemail + ", pcontactNumber="
				+ pcontactNumber + ", ptotalAmount=" + ptotalAmount + ", pdeliveryAddress=" + pdeliveryAddress
				+ ", porderDate=" + porderDate + ", porderFinalized=" + porderFinalized + "]";
	}
	
	
}
