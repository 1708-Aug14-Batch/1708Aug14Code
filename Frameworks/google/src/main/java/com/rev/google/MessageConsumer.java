package com.rev.google;

import com.revature.messanger.HelloWorld;
import com.revature.messanger.HelloWorldImplService;

public class MessageConsumer {

	public static void main(String[] args) {
		//service using the port
		HelloWorld service = new HelloWorldImplService().getHelloWorldImplPort();
//		
//		while(true) {
//			service.sayHi("i lost the game");
//		}
	}
}
