package com.bank.main;

import java.util.Scanner;

import com.bank.service.Service;

public class RunBank {

	//implementation to actually run the bank application
	public static void main(String[] args) {
		
//		Service bankService = new Service();
		
		int choice;

		Scanner sc = new Scanner(System.in);

		System.out.println("Do you want to login(1), create account(2), exit(3)? " ); // asking user 
		choice = sc.nextInt(); // setting user input from user


		switch (choice) {
			case 1:  Service.login();
				break;
			case 2:  
				break;
			case 3:  
				break;
		}

	}
	
//	static void login() {}
	 /*
	  * Requirements: As a user I can,
	  * -login
	  * -create an account
	  * -logout
	  * -withdraw or deposit funds
	  * -view my* account balance
	  * -edit my* information
	  * 
	  * Tech Specs
	  * -core java, file i/o
	  */

}
