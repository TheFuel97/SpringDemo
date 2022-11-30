package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost:3306/myhiber?useSSL=false";
		String user="root";
		String password="root";
		
		try {
			System.out.println("connecting to myhiber db....");
			Connection con = DriverManager.getConnection(url,user,password);
			System.out.println("Connection is successfull...");
			con.close();
			System.out.println(con.isClosed());
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
