package com.revature.logging;

import org.apache.log4j.Logger;

public class Logging {
	private static Logger logger;
	
	public static Logger getLogger() {
		if (logger == null)
			logger = Logger.getRootLogger();
		return logger;
	}
}
