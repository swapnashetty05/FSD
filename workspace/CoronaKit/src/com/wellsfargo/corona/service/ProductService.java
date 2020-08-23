package com.wellsfargo.corona.service;

import java.util.List;


import com.wellsfargo.corona.entity.Product;
import com.wellsfargo.corona.exception.ProductException;

public interface ProductService {
	
	Product validateAndAdd(Product product) throws ProductException;

	Product validateAndSave(Product product) throws ProductException;

	boolean deleteProduct(int productId) throws ProductException;

	Product getProduct(int productId) throws ProductException;

	List<Product> getAllProduct() throws ProductException;
	

}
