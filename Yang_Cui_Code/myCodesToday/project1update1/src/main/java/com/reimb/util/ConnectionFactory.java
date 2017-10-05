package com.reimb.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private static ConnectionFactory cf = null;
	private static Boolean build = true;
	private ConnectionFactory(){
		build = false;
	}
	
	// Provides method callers with the CF object and synchronized to prevent 2 threads from create connection object simultaneously
	public static synchronized ConnectionFactory getInstance() {
		//synchronized means thread safe
		if(build==true){
			cf=new ConnectionFactory();
		}
		return cf;
	}
	
	public Connection getConnection(){
		Connection conn=null;
		try{
			Properties prop=new Properties();
			prop.load(new FileReader("C:/Users/1Z4XS/workspace/project1update1/src/main/java/com/reimb/util/database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn=DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("pwd"));
		}catch (Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}
