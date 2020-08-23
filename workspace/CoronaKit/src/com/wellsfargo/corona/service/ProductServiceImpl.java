package com.wellsfargo.corona.service;

import java.util.ArrayList;
import java.util.List;
import com.wellsfargo.corona.dao.ProductDAO;
import com.wellsfargo.corona.dao.ProductDAOImpl;
import com.wellsfargo.corona.entity.Product;
import com.wellsfargo.corona.exception.ProductException;


public class ProductServiceImpl implements ProductService {


	ProductDAO productDao;

	public ProductServiceImpl() {
		productDao = new ProductDAOImpl();
	}
	
	private boolean isValidProduct(Product product) throws ProductException {
		boolean isValid = true;

		List<String> errMsg = new ArrayList<>();

		if (product != null) {

			if (!isValidProductName(product.getPproductName())) {
				isValid = false;
				errMsg.add("productName  must be a appropriate");
			}

			if (!isValidDescription(product.getPdescription())) {
				isValid = false;
				errMsg.add("description  must be appropriate");
			}

			if (!isvalidCost(product.getPcost())) {
				isValid = false;
				errMsg.add("cost must be a positive or non repetative number");
			}

			if (!isvalidAvailabilityStatus(product.getPavailabilityStatus())) {
				isValid = false;
				errMsg.add("availabilityStatus must be  AVAILABLE or SOLDOUT");
			}

			if (!errMsg.isEmpty()) {
				throw new ProductException(errMsg.toString());
			}

		} else {
			isValid = false;
		}
		return isValid;
	}
	
	private boolean isValidProductId(Integer productId) {
		return productId != null && productId > 0;
	}

	private boolean isvalidCost(Double cost) {

		return cost != null && (cost >= 0 || cost <= 1);
	}
	
	
	private boolean isValidProductName(String productName) {
		return productName != null && (productName.length() > 3 && productName.length() < 25);
	}
	
	private boolean isValidDescription(String description) {
		return description != null && (description.length() > 3 && description.length() < 75);
	}
	
	private boolean isvalidAvailabilityStatus(String availabilityStatus) {
		return availabilityStatus != null && (availabilityStatus.length() > 3 && availabilityStatus.length() < 15);
	}
	
	@Override
	public Product validateAndAdd(Product product) throws ProductException {
		if(isValidProduct(product)) {
			productDao.add(product);
			
		}
		return product;
	}

	@Override
	public Product validateAndSave(Product product) throws ProductException {
		if(isValidProduct(product)) {
			productDao.save(product);
			
		}
		return product;
	}

	@Override
	public boolean deleteProduct(int productId) throws ProductException {
		return productDao.deleteByID(productId);
	}

	@Override
	public Product getProduct(int productId) throws ProductException {
		return productDao.getId(productId);
	}

	@Override
	public List<Product> getAllProduct() throws ProductException {
		return productDao.getAll();
	}

}
