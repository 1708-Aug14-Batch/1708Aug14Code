package com.revature.andy.beans;

public class HiRevature {

	private HelloWorld hello;
	
	public HiRevature() {
		
	}
	
	public HiRevature(HelloWorld hello) {
		super();
	}

	public void getHelloMessage() {
		hello.getMessage();
	}
	
	public HelloWorld getHello() {
		return hello;
	}

	public void setHello(HelloWorld hello) {
		this.hello = hello;
	}
	
}
