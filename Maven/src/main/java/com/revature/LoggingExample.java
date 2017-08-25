package com.revature;

import org.apache.log4j.Logger;

public class LoggingExample {

	private static Logger log = Logger.getRootLogger();
	
	public static void main(String[] args) {
		log.trace("trace");
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
		log.fatal("fatal");
	}
	
}


