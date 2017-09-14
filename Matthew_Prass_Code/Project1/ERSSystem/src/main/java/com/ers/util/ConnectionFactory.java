package com.ers.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	
	private static ConnectionFactory cf = null;
	private static Boolean build = true;
	
	private ConnectionFactory()
	{
		build = false;
	}
	
	public static synchronized ConnectionFactory getInstance()
	{
		if(build == true)
			cf = new ConnectionFactory();
		
		return cf;
	}
	
	public static Connection getConnection()
	{
		Connection conn = null;
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("C://Users//Matt//my_git_repos//1708Aug14Code//Matthew_Prass_Code//Project1//ERSSystem//src//main//java//com//ers//util//database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("usr"),prop.getProperty("pwd"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return conn;
	}

}

