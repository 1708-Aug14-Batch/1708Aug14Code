package com.bank.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.bank.util.ConnectionFactory;

public class ConnectionFactory {
	private static ConnectionFactory cf = null;
	private static Boolean build = true;
	
	private ConnectionFactory(){
		build = false;
	}
	/**
	 * provides method callers with the CF object
	 * and synchronized to prevent 2 threads from creation
	 * connection object simultaneously
	 * @return
	 */
	public static synchronized ConnectionFactory getInstance(){
		if(build == true){
			cf = new ConnectionFactory();
		}
		return cf;
	}
	public Connection getConnection(){
		
		Connection conn = null;
		try{
			Properties prop = new Properties();
			prop.load(new FileReader("C:/Users/joshw/my_git_repos/1708Aug14Code/Joshua_Wurdemann_Code/SQL/BankingAssignmentDatabase/src/com/bank/util/DataBaseProperties"));
		Class.forName(prop.getProperty("driver"));
		
		conn = DriverManager.getConnection(prop.getProperty("url"),
				prop.getProperty("usr"), prop.getProperty("pwd"));
		} catch(Exception e){
			e.printStackTrace();
		}
		return conn;
		
	}
}

