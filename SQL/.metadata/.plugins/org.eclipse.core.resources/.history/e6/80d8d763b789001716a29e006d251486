package com.ex.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class SingleConnection {
	
	private static SingleConnection cf = null;
	private static Boolean build = true;
	
	private SingleConnection() {
		build = false;
	}
	
	/*
	 * Provides method callers with the CF object and synchronized
	 * to prevent multiple threads from creating connection objects simultaneously
	 */
	public static synchronized SingleConnection getInstance() {
		if (build)
			cf = new SingleConnection();
		
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("C:/Users/Surplus/my_git_repos/1708Aug14Code/SQL/IntroToJDBC/src/com/ex/util/database.properties"));
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("usr"),
					prop.getProperty("pwd"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
