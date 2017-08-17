package com.revature.exceptions;

public class MyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2823857322503442293L;

	public MyException(String message) {
		super(message);
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}
