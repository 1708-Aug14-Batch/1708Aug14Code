package revature;

import org.apache.log4j.Logger;

public class LoggingExample {

	private static Logger log = Logger.getRootLogger();
	
	public static void main(String[] args) {
		log.trace("most specific");
		log.debug("debugging");
		log.info("generalized information from system");
		log.warn("abnormal behavior");
		log.error("recoverable but affects user");
		log.fatal("most serious, something bad enough happened to make unrecoverable");
	}
}
