package com.revature.google;

import com.revature.messanger.HelloWorld;
import com.revature.messanger.HelloWorldImplService;

public class MessageConsumer {
	public static void main(String[] args) {
		//Service using the port
		HelloWorld service = new HelloWorldImplService().getHelloWorldImplPort();
		service.sayHi("peace");
	}
}
