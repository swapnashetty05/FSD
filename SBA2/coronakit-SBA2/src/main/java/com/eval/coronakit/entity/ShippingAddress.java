package com.eval.coronakit.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Embeddable
public class ShippingAddress {

	@NotNull(message = "ShippingAddress cannot be null ")
	@NotBlank(message = "ShippingAddress cannot be blank ")

	private String Address;

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

}
