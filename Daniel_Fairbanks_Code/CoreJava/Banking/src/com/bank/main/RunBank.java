package com.bank.main;

import com.bank.service.Service;

public class RunBank {

	public static void main(String[] args) {

		Service bankService = new Service();
		bankService.run();
		
	}
	
}
