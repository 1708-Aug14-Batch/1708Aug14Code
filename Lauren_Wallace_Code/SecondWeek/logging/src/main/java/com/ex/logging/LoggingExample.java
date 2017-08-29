package com.ex.logging;

import org.apache.log4j.Logger;

public class LoggingExample {
	
	private static Logger log = Logger.getRootLogger();
	
	public static void main(String[] args) {
		
		log.trace("this is 1st one");
		
	}
	
}
