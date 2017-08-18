package com.bank.main;

import java.util.Scanner;

import com.bank.service.Service;

public class RunBank {

	static Service bankService = new Service();
	static Scanner scan = new Scanner(System.in);
	
	//implementation to actually run bank application
	public static void main(String[] args) {
		boolean runProgram = true;
		while(runProgram) {
			switch(createLogChoice()) {
			case 1:
				createAccount();
				break;
			case 2:
				login();
				break;
			case 3:
				runProgram = false;
				break;
			}
		}
		scan.close();
	}
	
	static int createLogChoice() {
		System.out.println("Do you want to Create a new account or login or exit? (1/2/3): ");
		int choice = 0; //0 = no choice, 1 = create account, 2 = login, 3 = exit
		while(choice == 0) {
			String tempChoice = scan.nextLine().trim();
			switch(tempChoice) {
			case "1":
				choice = 1;
				break;
			case "2":
				choice = 2;
				break;
			case "3":
				choice = 3;
				break;
			default:
				System.out.println("That is not a valid entry, please try again. (1/2/3): ");
				choice = 0;
				break;
			}
		}
		return choice;
	}
	
	static void createAccount() {
		System.out.println("Username: ");
		String username = scan.nextLine().trim();
		while(bankService.checkAccounts(username)) {
			System.out.println("Username already taken please try again: ");
			username = scan.nextLine().trim();
		}
		System.out.println("Password: ");
		String password = scan.nextLine().trim();
		System.out.println("firstname: ");
		String firstname = scan.nextLine().trim();
		System.out.println("lastname: ");
		String lastname = scan.nextLine().trim();
		System.out.println("Starting blanance: ");
		double initialBalance = 0;
		while(true) {
			try {
				String b = scan.nextLine().trim();
				initialBalance = Double.parseDouble(b);
				break;
			}
			catch(NumberFormatException e) {
				System.out.println("Not valid number, please try again: ");
			}
		}
		bankService.createUser(firstname, lastname, username, password, initialBalance);
		bankService.manageAccount(scan);
	}
	
	static void login() {
		String inuser = "";
		String inpass = "";
		boolean passed = false;
		while(!passed) {
			System.out.println("What is your username: ");
			inuser = scan.nextLine().trim();
			System.out.println("What is your password: ");
			inpass = scan.nextLine().trim();
			if(bankService.attemptLogin(inuser, inpass)) {
				passed = true;
			}
			else {
				System.out.println("Sorry, wrong username or password. Try again or cancel? (1/2): ");
				int choice = 0;
				while(choice == 0) {
					switch(scan.nextLine().trim()) {
					case "1":
						choice = 1;
						break;
					case "2":
						choice = 2;
						break;
					default:
						choice = 0;
						System.out.println("That is not a valid entry, please try again. (1/2): ");
						break;
					}
				}
				if(choice == 1) {
					continue;
				}
				else if(choice == 2) {
					break;
				}
			}
		}
		if(passed) {
			bankService.manageAccount(scan);
		}
	}
	
	/*
	 * Requirements: As a user I can,
	 * - login *
	 * - create an account *
	 * - logout *
	 * - withdraw or deposit funds *
	 * - view my* account information *
	 * - edit my* information *
	 * - delete account *
	 * 
	 * Tech Specs
	 * - core java, file i/o
	 */
}
