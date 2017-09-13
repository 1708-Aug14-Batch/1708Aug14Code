package com.revature.util;

import org.apache.log4j.Logger;

public class LoggerSingleton {
	
	private static LoggerSingleton singleton = null;
	private static Boolean hasInstance = false;
	
	private LoggerSingleton() {
		hasInstance = true;
	}
	
	public static synchronized LoggerSingleton getInstance() {
		if (!hasInstance) {
			singleton = new LoggerSingleton();
		}
		return singleton;
	}
	
	public Logger getLogger() {
		return Logger.getLogger(LoggerSingleton.class.getName());
	}

}
