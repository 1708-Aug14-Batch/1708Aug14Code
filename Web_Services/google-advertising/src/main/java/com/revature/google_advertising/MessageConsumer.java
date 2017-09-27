package com.revature.google_advertising;

import com.revature.messanger.HelloWorld;
import com.revature.messanger.HelloWorldImplService;

public class MessageConsumer {

	public static void main(String[] args) {
		// Grab the Service by using the port
		HelloWorld service = new HelloWorldImplService().getHelloWorldImplPort();

		service.sayHi("");
	}

}
