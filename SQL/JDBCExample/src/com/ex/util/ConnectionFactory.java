package com.ex.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	
	private static Boolean build = true;
	private static ConnectionFactory cf = null;
	
	/*
	 * make constructor private to hide it from the rest of the project
	 * the compiler will not allow other programs to instantiate the class
	 * ... what does this remind us of?
	 * a design pattern, you say??? which one?
	 */
	private ConnectionFactory(){
		build = false;
	}
	
	/*
	 * provides method callers with the ConnectionFactory object and
	 * synchronizes to prevent two threads from creating connection
	 * objects simultaneously  
	 */
	public static synchronized ConnectionFactory getInstance(){
		
		if (build== true){
			cf = new ConnectionFactory();	
		}
		return cf;
	}
	
	// location for properties file will be wherever you create it. include full file path
	// C:/Users/Genesis/my_git_repos/1708Aug14Code/SQL/JDBCExample/src/com/ex/util/database.properties
	public Connection getConnection(){
		Connection conn = null;
		try{
			Properties prop = new Properties();
			prop.load(new FileReader("C:/Users/Genesis/my_git_repos/1708Aug14Code/SQL/JDBCExample/src/com/ex/util/database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("usr"),prop.getProperty("pwd"));
			/*
			 *  The DriverManager provides a basic service for managing a set
			 *   of JDBC drivers. As part of its initialization, the DriverManager 
			 *   class will attempt to load the driver classes
			 *    referenced in the "jdbc.drivers" system property.		
			 */
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}

}
