package com.bank.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.bank.util.ConnectionFactory;

public class ConnectionFactory {

	private static ConnectionFactory cf = null;
	private static Boolean build = true;
	
	private ConnectionFactory() {
		build = false;
	}
	
	/*
	 * provides method callers with the CF object
	 * and synchronized to prevent 2 threads from creating
	 * connection objects simultaneously
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
			prop.load(new FileReader("E:/Thingsn'Stuff/RevTrain/Repos/1708Aug14Code/Trevor_Lory_Code/SQLJava/BankRefactorProject/src/com/bank/util/database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("pwd"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
