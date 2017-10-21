package com.rev.soap;

public class HelloWorldImpl implements HelloWorld{

	@Override
	public String sayHi(String message) {
		System.out.println("SOAP-WS-SayHi arg: "+ message );
		return "Hi " + message;
	}
	


}
