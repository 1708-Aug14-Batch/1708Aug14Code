package com.revature;
import org.apache.log4j.Logger;
public class LoggingExample {
	
	static Logger l = Logger.getRootLogger();
	public static void main(String[] args) {
		
		l.trace("kjhdnklwjedf:");
		l.info("lololo");
		l.fatal("oh no :(");
	}

}
