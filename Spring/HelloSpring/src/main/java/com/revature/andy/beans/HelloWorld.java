package com.revature.andy.beans;

public class HelloWorld {

	private String message;
	

	public HelloWorld() {
		System.out.println("empty con");
	}

	public HelloWorld(String message) {
		System.out.println("arg con");
	}

	public String getMessage() {
		System.out.println(message);
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void init() {
		System.out.println("initializing bean");
	}
	
	public void destroy() {
		System.out.println("destorying bean");
	}
	
}
