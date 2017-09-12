package com.bank.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

	private static ConnectionFactory cf = null;
	private static Boolean build = true; // Wrapper class Boolean can be null
	
	private ConnectionFactory() {
		build = false;
	}
	
	/*
	 * Provides method callers with the CF object
	 * and synchronized to prevent 2 threads from
	 * creating connection object simultaneously
	 */
	public static synchronized ConnectionFactory getInstance() {
		if(build==true) {
			cf = new ConnectionFactory();
		}
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("C:/Users/Katie/my_git_repos/1708Aug14Code/Katherine_Bixby_Code/SQL/Bank/src/com/bank/util/database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("usr"),
					prop.getProperty("pwd"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
