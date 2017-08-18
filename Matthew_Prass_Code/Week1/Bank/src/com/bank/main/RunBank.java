package com.bank.main;

import com.bank.service.Service;

public class RunBank {
	
	
	//implementation to actually run bank application
	public static void main(String[] args) {
		
		Service bankService = new Service();
		
		bankService.mainMenu();
	
	}
	

}
