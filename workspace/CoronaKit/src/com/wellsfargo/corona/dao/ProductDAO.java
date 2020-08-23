package com.wellsfargo.corona.dao;

import java.util.List;
import com.wellsfargo.corona.entity.Product;
import com.wellsfargo.corona.exception.ProductException;

public interface ProductDAO {

	Product add(Product product) throws ProductException;

	Product save(Product product) throws ProductException;

	boolean deleteByID(int productId) throws ProductException;

	List<Product> getAll() throws ProductException;

	Product getId(int productId) throws ProductException;

}
