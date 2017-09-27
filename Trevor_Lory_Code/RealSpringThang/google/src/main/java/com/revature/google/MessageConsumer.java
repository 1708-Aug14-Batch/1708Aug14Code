package com.revature.google;

import com.revature.messanger.HelloWorld;
import com.revature.messanger.HelloWorldImplService;

public class MessageConsumer {

	public static void main(String[] args) {
		//Service using the port (service locator pattern)
		HelloWorld service = new HelloWorldImplService().getHelloWorldImplPort();
		service.sayHi("Hello World isn't complicated? what!?");
	}
	
}
