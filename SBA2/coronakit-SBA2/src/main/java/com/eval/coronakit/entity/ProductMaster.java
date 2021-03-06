package com.eval.coronakit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ProductMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "ProductName cannot be a null")
	@Size(min = 2, message = "ProductName should be min 2 characters")
	private String productName;

	@NotNull(message = "Product cost cannot be null")
	@Min(value = 10, message = "Cost must be more than or equal to 10")
	private Integer cost;

	@NotNull(message = "Product Description cannot be a null")
	@Size(min = 5, message = "Product Description should be min 5 characters")
	private String productDescription;

	public ProductMaster() {

	}

	
	public ProductMaster(int id,
			@NotNull(message = "ProductName cannot be a null") @Size(min = 2, message = "ProductName should be min 2 characters") String productName,
			@NotNull(message = "Product cost cannot be null") @Min(value = 10, message = "Cost must be more than or equal to 10") Integer cost,
			@NotNull(message = "Product Description cannot be a null") @Size(min = 5, message = "Product Description should be min 5 characters") String productDescription) {
		super();
		this.id = id;
		this.productName = productName;
		this.cost = cost;
		this.productDescription = productDescription;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Override
	public String toString() {
		return "ProductMaster [id=" + id + ", productName=" + productName + ", cost=" + cost + ", productDescription="
				+ productDescription + "]";
	}

}
