package com.bank.BankConsume;

import com.bank.webservices.UserService;
import com.bank.webservices.UserServiceImplService;

public class MessageConsume {

	
	public static void main(String[] args) {
		//service using the port
		UserService service = new UserServiceImplService().getUserServiceImplPort();

		String response = service.getUser("false");
		System.out.println(response);
	}
}
