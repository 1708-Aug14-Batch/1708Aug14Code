package com.bank.run;

import java.util.Scanner;

import pojos.User;

import com.bank.service.Service;

public class RunBank {

	private static User currentUser;
	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);

		Service service = new Service();


		scan.close();
	}

	private static User getCurrentUser() {

		return currentUser;
	}

	private static void login() {

	}

	private static void logout() {
		if (confirm("logout")) {
			currentUser = null;
		}
		else {
			
		}
	}

	private static void createAccount() {

	}

	private static void withdraw() {

	}

	private static void deposit() {

	}

	private static void viewBalance() {

	}

	private static void editAccount() {

	}

	private static boolean confirm(String message) {
		System.out.println("Are you sure you want to " + message + "? (y/n)");
		return "y".equals(scan.nextLine());
	}

	/*
	 * Requirements: As a user I can,
	 *  - Login
	 *  - Create an account
	 *  - Logout
	 *  - Withdraw and deposit funds
	 *  - View my account balance
	 *  - Edit my account info
	 *  
	 * Tech specs:
	 *  - Core Java, file I/O
	 *  
	 */

}
