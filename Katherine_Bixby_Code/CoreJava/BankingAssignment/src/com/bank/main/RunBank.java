package com.bank.main;

import java.util.Scanner;

import com.bank.service.Service;

/**
 * The Runner for the other classes. This is where the Banking application is tested.
 * This is where all the direct user input is processed and used to call methods from the service class accordingly.
 * 
 * @author Katie
 *
 */

public class RunBank {
	
	public static String loggedIn;	// The username of the person currently logged in. If no one is logged in, this String is set to a default of ""
	private static Service bankService;	// The instance of the service class.
	static Scanner scan = new Scanner(System.in);	// The scanner to be passed around throughout the entire program.

	
	public static void main(String[] args) {
		bankService = new Service();
		loggedIn = "";
		viewOptions();	// This method runs recursively so that the user can continue selecting new options after completing one.
		
	}
	
	/**
	 * The recursive method that displays the options a user has to them, and makes calls to the bank scanner accordingly.
	 * Once the current call completes, the method calls itself again, repeating the cycle.
	 * If someone is currently logged in, it gives them a certain set of menu options, and if not, it gives them a different set.
	 * If the user inputs an option that doesn't exist, they are asked to provide a different response.
	 */
	static void viewOptions() {
		int selection = 0;
		if(loggedIn=="") {
			System.out.println("===========================================");
			System.out.println("What would you like to do?: ");
			System.out.println("| 1. Login");
			System.out.println("| 2. Create Account");
			System.out.println("===========================================");
			selection = scan.nextInt();
			if(selection==1) {
				login();
			}
			else if(selection==2) {
				createAccount();
			}
			else {
				System.out.println("Please select an option.");
			}
		}
		else {
			System.out.println("===========================================");
			System.out.println("What would you like to do?: ");
			System.out.println("| 1. Withdraw Funds");
			System.out.println("| 2. Deposit Funds");
			System.out.println("| 3. Edit Account Details");
			System.out.println("| 4. View Account Balance");
			System.out.println("| 5. Logout");
			System.out.println("===========================================");
			selection = scan.nextInt();
			if(selection==1) {
				withdrawFunds();
			}
			else if(selection==2) {
				depositFunds();
			}
			else if(selection==3) {
				editInfo();
			}
			else if(selection==4) {
				viewBalance();
			}
			else if(selection==5) {
				logout();
			}
			else {
				System.out.println("Please select what you'd like to do");
			}
		}
		viewOptions();
		scan.close();
	}
	
	/**
	 * Prompts the user for a login, and tests to validate if the user is an actual account holding member.
	 * If they are not, it sends you back to the viewOptions method.
	 * Tests for existing username, then asks for password, then tests the username with the password.
	 * If login is successful, the static variable loggedIn is updated to indicate which user is logged in.
	 * Only one user can be logged in at any given time.
	 */
	static void login() {
		System.out.print("Please enter your username: ");
		scan.nextLine().trim();
		String userName = scan.nextLine().trim();
		boolean doesExist = bankService.exists(userName);
		if(doesExist) {
			System.out.print("Please enter your password: ");
			String password = scan.nextLine().trim();
			boolean doLogin = bankService.correctLogin(userName, password);
			System.out.println("");
			if(doLogin) {
				loggedIn = userName;
				System.out.println("Logged in as: "+loggedIn);
			}
			else {
				System.out.println("Incorrect Login/Password Given");
			}
		}
		else {
			System.out.println("That account does not exist, please create a new account!");
		}
	}
	
	/**
	 * Call for creating a new account using the bank service.
	 */
	static void createAccount() {
		bankService.addNewUser(scan);
		System.out.println("");
	}
	
	/**
	 * Logs the user out by setting the loggedIn static variable to "".
	 */
	static void logout() {
		loggedIn = "";
	}
	
	/**
	 * Call for withdrawing funds using the bank service.
	 * Tests to ensure that a user is properly logged in before commencing with this action.
	 */
	static void withdrawFunds() {
		if(loggedIn.equals("")) {
			System.out.println("-----ACCESS DENIED-----");
		}
		else {
			bankService.withdrawMoney(true, loggedIn, scan);
		}
	}
	
	/**
	 * Call for depositing funds using the bank service.
	 * Tests to ensure that a user is properly logged in before commencing with this action.
	 */
	static void depositFunds() {
		if(loggedIn.equals("")) {
			System.out.println("-----ACCESS DENIED-----");
		}
		else {
			bankService.depositMoney(true, loggedIn, scan);
		}
	}
	
	/**
	 * Call for viewing the balance using the bank service.
	 * Tests to ensure that a user is properly logged in before commencing with this action.
	 */
	static void viewBalance() {
		if(loggedIn.equals("")) {
			System.out.println("-----ACCESS DENIED-----");
		}
		else {
			bankService.checkBalance(true,loggedIn);
		}
	}
	
	/**
	 * Call for editing info using the bank service.
	 * Tests to ensure that a user is properly logged in before commencing with this action.
	 */
	static void editInfo() {
		if(loggedIn.equals("")) {
			System.out.println("-----ACCESS DENIED-----");
		}
		else {
			bankService.editAUser(true, loggedIn,scan);
		}
	}
	
	
	
	
}
