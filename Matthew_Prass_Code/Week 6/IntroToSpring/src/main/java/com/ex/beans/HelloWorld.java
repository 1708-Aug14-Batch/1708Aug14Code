package com.ex.beans;

public class HelloWorld {

	public HelloWorld() {
		System.out.println("in default");
	}
	public HelloWorld(String test) {
		System.out.println(test);
	}
	private String message;
	private String test;
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void getMessage() {
		System.out.println(message);
	}
}
