package com.wellsfargo.corona.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.wellsfargo.corona.entity.Product;
import com.wellsfargo.corona.exception.ProductException;


public class ProductDAOImpl implements ProductDAO {

	/*
	 * Query strings
	 */
	private static final String INS_Product_QRY = "INSERT into products(pproductName,pdescription,pcost,pavailabilityStatus) values(?,?,?,?)";
	private static final String UPD_Product_QRY = "UPDATE products SET pproductName=?,pdescription=?,pcost=?,pavailabilityStatus=? where pproductId=? ";
	private static final String DEL_Product_QRY = "DELETE from products where pproductId=? ";
	private static final String GET_BY_ID_Product_QRY = "SELECT pproductId,pproductName,pdescription,pcost,pavailabilityStatus FROM products where pproductId=?";
	private static final String GET_ALL_Product_QRY = "SELECT pproductId,pproductName,pdescription,pcost,pavailabilityStatus FROM products";
	
	@Override
	public Product add(Product product) throws ProductException {
		if (product != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(INS_Product_QRY);) {

				
				pst.setString(1, product.getPproductName());
				pst.setString(2, product.getPdescription());
				pst.setDouble(3, product.getPcost());
				pst.setString(4, product.getPavailabilityStatus());

				pst.executeUpdate();

			} catch (SQLException exp) {
				throw new ProductException("An error occured in connection, couldnt add product");
			}
		}
		return product;
	}

	@Override
	public Product save(Product product) throws ProductException {
		if (product != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(UPD_Product_QRY);) {

				pst.setInt(5, product.getPproductId());
				pst.setString(1, product.getPproductName());
				pst.setString(2, product.getPdescription());
				pst.setDouble(3,  product.getPcost());
				pst.setString(4, product.getPavailabilityStatus());

				pst.executeUpdate();

			} catch (SQLException exp) {
				throw new ProductException("An error occured in connection, couldnt save");
			}
		}
		return product;
	}

	@Override
	public boolean deleteByID(int productId) throws ProductException {
		boolean isDeleted = false;

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(DEL_Product_QRY);) {

			pst.setInt(1, productId);

			int rowsCount = pst.executeUpdate();
			isDeleted = rowsCount > 0;

		} catch (SQLException exp) {
			throw new ProductException("An error occured in connection, couldnt delete");
		}

		return isDeleted;
	}

	@Override
	public List<Product> getAll() throws ProductException {
		List<Product> products = new ArrayList<>();
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(GET_ALL_Product_QRY);) {

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setPproductId(rs.getInt(1));
				product.setPproductName(rs.getString(2));
				product.setPdescription(rs.getString(3));
				product.setPcost(rs.getDouble(4));
				product.setPavailabilityStatus(rs.getString(5));

				products.add(product);
			}

		} catch (SQLException exp) {
			throw new ProductException("An error occured in connection, couldnt getall Products");
		}

		return products;
	}

	@Override
	public Product getId(int productId) throws ProductException {
		Product product = null;

		
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(GET_BY_ID_Product_QRY);) {

			pst.setInt(1, productId);

			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				product = new Product();
				product.setPproductId(rs.getInt(1));
				product.setPproductName(rs.getString(2));
				product.setPdescription(rs.getString(3));
				product.setPcost(rs.getDouble(4));
				product.setPavailabilityStatus(rs.getString(5));

			}

		} catch (SQLException exp) {
			throw new ProductException("An error occured in connection, couldnt get product by id");
		}

		return product;
	}

}
