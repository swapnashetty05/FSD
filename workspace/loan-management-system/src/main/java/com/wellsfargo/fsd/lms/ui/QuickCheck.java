package com.wellsfargo.fsd.lms.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class QuickCheck {

	public static void main(String[] args) {
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","root");
			System.out.println("Con opened");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
