package com.ex.soap;

import javax.jws.WebService;

@WebService(endpointInterface = "com.revature.soap.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String sayHi(String text) {
		System.out.println("SOAP-WS-SayHi arg:" + text);
		return "Hi " + text;
	}

}
