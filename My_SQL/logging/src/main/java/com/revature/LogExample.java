package com.revature;

import org.apache.log4j.Logger;

public class LogExample {
	
	private static Logger log = Logger.getRootLogger();

	public static void main(String[] args) {
		
		log.trace("trace test");
		log.error("error test");
	}
}
