package com.revature.andy.ConsumeWebservice;

import com.revature.messanger.HelloWorld;
import com.revature.messanger.HelloWorldImplService;

public class MessageConsumer {

	
	public static void main(String[] args) {
		HelloWorld service = new HelloWorldImplService().getHelloWorldImplPort();
		service.sayHi("");
	}
}
