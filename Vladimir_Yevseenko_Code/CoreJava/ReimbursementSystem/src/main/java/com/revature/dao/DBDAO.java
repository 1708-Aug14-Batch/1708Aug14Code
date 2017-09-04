package com.revature.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.revature.logging.Logging;
import com.revature.utils.ConnectionFactory;

public class DBDAO {
	private Connection dbConn;
	private Logger log;
	
	public DBDAO() {
		log = Logging.getLogger();
		dbConn = ConnectionFactory.getInstance().getConnection();
		log.debug("DBDAO() instance created");
	}
	
	public static void main(String[] args) {
		DBDAO n = new DBDAO();
	}
	
	
	
}
