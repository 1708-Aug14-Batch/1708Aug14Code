package com.ex.beans;

public class HelloWorld {
	
	public HelloWorld() {
		System.out.println("in empty constructor!");
	}
	
	public HelloWorld(String test) {
		System.out.println(test);
	}

	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void getMessage() {
		System.out.println("Your message: " + message);
	}
	
	public void init() {
		System.out.println("initializing bean");
	}
	
	public void destroy() {
		System.out.println("destroying bean");
	}
	
}
