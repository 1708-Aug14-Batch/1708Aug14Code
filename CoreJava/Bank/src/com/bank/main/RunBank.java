package com.bank.main;

import java.util.Random;
import java.util.Scanner;

import com.bank.service.Service;

public class RunBank {

	//static Scanner scan = new Scanner(System.in);

	//static Service bankService = new Service();
	
	//Service bankService = new Service();
	
	// implementation to actually run the application
	public static void main(String[] args) {
		Service bankService = new Service();
		
		start(bankService);
		
	}
	
	static void start(Service bankService) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {

			System.out.println("Please Enter A Number From the Following\\n"
					+ "1: Create Account \n"
					+ "2: Login");
			
			int input = scan.nextInt();
			
			if(input==1) {
				createAcct(bankService);
			}else if(input==2) {
				login(bankService);
				break;
			}
		}
		
		//options(scan.nextInt());
		
	}
	
	static void createAcct(Service bankService) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter First Name");
		String fname = scan.nextLine().trim();
		
		System.out.println("Enter Last Name");
		String lname = scan.nextLine().trim();
		
		System.out.println("Enter Email");
		String email = scan.nextLine().trim();
		
		System.out.println("Enter Password");
		String pwd =  scan.nextLine().trim();
		
		if(bankService.createAccount(fname, lname, email, pwd)) {
			System.out.println("Account Created");
		}else {
			System.out.println("Fail Account Creation");
		}
	}
	
	static void login(Service bankService) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter Email");
		String email = scan.nextLine().trim();
		
		System.out.println("Enter Password");
		String pwd =  scan.nextLine().trim();
		
		bankService.login(email, pwd);
		
		System.out.println("main " + bankService.isLoggedIn());
		
		if(bankService.isLoggedIn()) {
			while(bankService.isLoggedIn()) {
				
				System.out.println("Please Enter A Number From the Following\n"
						+ "1: Check Balance\n"
						+ "2: Withdraw\n"
						+ "3: Deposit\n"
						+ "4: Change Information\n"
						+ "5: Logout");
				
				options(bankService, scan.nextInt());
			}
			
		}else {
			System.out.println("Login Failed");
		}
		
	}
	
	//System.out.println("class" + loggedIn);
	
	//static void
	
	static void options(Service bankService, int x) {
		switch(x) {
		case 1:System.out.println(bankService.getBalance());
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:bankService.logout();
			break;
		default:
			break;
		}
	}
	
	
	/*
	 * requirements
	 * 
	 * As a user I can:
	 * 
	 * login
	 * create account
	 * logout
	 * withdraw
	 * deposit
	 * view balance
	 * edit info
	 * 
	 * 
	 * Tech specs:
	 * 
	 * core java
	 * file i/o
	 * 
	 * 
	 */
}
