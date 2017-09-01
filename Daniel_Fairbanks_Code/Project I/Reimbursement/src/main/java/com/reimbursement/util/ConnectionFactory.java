package com.reimbursement.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import com.reimbursement.util.ConnectionFactory;

public class ConnectionFactory {
	private static ConnectionFactory cf = null;
	private static Boolean build = true;
	
	private ConnectionFactory() {
		build = false;
	}
	
	public static synchronized ConnectionFactory getInstance() {
		if (build == true)
			cf = new ConnectionFactory();
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("C://Users//Daniel//my_git_repos//1708Aug14Code//Daniel_Fairbanks_Code//Project I//Reimbursement//src//main//java//com//reimbursement//util//database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("usr"),
					prop.getProperty("pwd"));
		} catch (Exception e) {
			System.out.println("ERROR: Connection Factory");
		}
		return conn;
	}
}