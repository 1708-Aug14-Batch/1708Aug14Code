package com.ex.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	
	private static ConnectionFactory cf = null;
	private static Boolean build = true;
	
	private ConnectionFactory() {
		build = false;
	}
	
	/*
	 * providing method callers with the cf object
	 * and synchronized to prevent 2 threads from creating 
	 * a connection object simultaneously
	 */
	public static synchronized ConnectionFactory getInstance() {
		if(build == true) {
			cf = new ConnectionFactory();
		}
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("C:/Users/laure/my_git_repos/1708Aug14Code/Lauren_Wallace_Code/SecondWeek/HelloJBZ/src/com/ex/util/database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("pwd"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
