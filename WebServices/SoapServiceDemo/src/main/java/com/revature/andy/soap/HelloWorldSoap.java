package com.revature.andy.soap;

import javax.jws.WebService;

@WebService(endpointInterface="com.revature.andy.soap.HelloWorld")
public class HelloWorldSoap implements HelloWorld{

	@Override
	public String sayHi(String text) {
		System.out.println(text);
		return text;
	}
	
}
