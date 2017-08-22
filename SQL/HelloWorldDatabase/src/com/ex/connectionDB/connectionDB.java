package com.ex.connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connectionDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:chinook@//localhost:1521/xe","chinook","p4ssw0rd");
			System.out.println("Connection");
			Statement stmt = con.createStatement();
			ResultSet q = stmt.executeQuery("SELECT * FROM ALBUM");
			while(q.next()){
				System.out.println(q.getInt(1) + q.getString(2) + q.getInt(3));
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
