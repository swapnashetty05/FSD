package com.eval.coronakit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Coronakitdetails")
public class CoronaKit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "deliveryAddress")
	private ShippingAddress deliveryAddress;

	@Column(name = "OrderDate")
	private LocalDate orderDate;

	@Column(name = "TotalAmount")
	private int totalAmount;

	public CoronaKit() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ShippingAddress getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(ShippingAddress deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

}
