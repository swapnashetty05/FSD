package com.wellsfargo.fsd.coronakit.service;

import java.util.List;

import com.wellsfargo.fsd.coronakit.entity.ProductMaster;
import com.wellsfargo.fsd.coronakit.exception.CoronaException;

public interface ProductService {

	public ProductMaster addNewProduct(ProductMaster product) throws CoronaException;
	public List<ProductMaster> getAllProducts() throws CoronaException;
	public boolean deleteProduct(int productId) throws CoronaException;
	public ProductMaster getProductById(int productId)throws CoronaException;
}
