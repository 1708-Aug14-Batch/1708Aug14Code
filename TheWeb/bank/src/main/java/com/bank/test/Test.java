package com.bank.test;

import com.bank.service.Service;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Service service = new Service();
		
		System.out.println(service.validateUser("email"));
	}

}
