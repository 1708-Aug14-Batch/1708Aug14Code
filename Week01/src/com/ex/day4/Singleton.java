package com.ex.day4;

public enum Singleton {
	INSTANCE;
	private final String MESSAGE = "There is only one of me";
	public String getMessage() {return MESSAGE;}
}
