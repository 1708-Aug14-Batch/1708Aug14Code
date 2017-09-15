package com.revature.util;

public enum Status {
	
	PENDING(1),
	APPROVED(2),
	DENIED(3);
	
	private final int statusCode;
	
	private Status(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public int getValue() {
		return this.statusCode;
	}

}
