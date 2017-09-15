package com.reimbursments.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private static ConnectionFactory bf = null;
	private static Boolean build = true;
	
	private ConnectionFactory()
	{
		build = false;
	}
	public static synchronized ConnectionFactory getInstance()
	{
		if(build == true)
			bf = new ConnectionFactory();
		
		return bf;
	}
	public Connection getConnection()
	{
		Connection conn = null;
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("C://Users//ChaosDragon//my_git_repos//1708Aug14Code//Joshua_Locklear_Code//WeekOneCoreJava//Reimburments//src/main//java//com//reimbursments//util//database.properties"));
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
