package com.bank.run;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

import pojos.User;

import com.bank.dao.DaoTextImpl;
import com.bank.service.Service;

public class RunBank {

	private static User currentUser;
	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		
		startMenu();

		scan.close();
	}

	private static void startMenu() {
		for (;;) {
			System.out.println();
			System.out.println("Welcome to the bank!");
			System.out.println("1. Login to account");
			System.out.println("2. Create account");
			System.out.println("3. Exit");

			switch (scan.nextLine()) {
			case "1":
				loginDialogue();
				break;
			case "2":
				createAccountDialogue();
				break;
			case "3":
				System.exit(0);
			default:
			}
		}
	}

	private static String mainMenu() {
		User user = Service.getCurrentUser();
		for (;;) {
			System.out.println();
			System.out.println("Welcome " + user.getFirst() + " " + user.getLast() + "!");
			System.out.println("1. View balance");
			System.out.println("2. Withdraw");
			System.out.println("3. Deposit");
			System.out.println("4. Edit account");
			System.out.println("5. Logout");

			switch (scan.nextLine()) {
			case "1":
				viewBalanceDialogue();
				break;
			case "2":
				withdrawDialogue();
				break;
			case "3":
				depositDialogue();
				break;
			case "4":
				editAccountDialogue();
				break;
			case "5":
				logoutDialogue();
				break;
			default:
			}
		}
	}

	private static void loginDialogue() {
		System.out.println();
		String email = getUserInput("Email");
		String password = getUserInput("Password");

		String errorMessage;
		if ((errorMessage = Service.loginUser(email, password)) != null) {
			System.out.println("Error: " + errorMessage);
			startMenu();
		}
		else {
			mainMenu();
		}
	}

	private static void logoutDialogue() {
		System.out.println();
		if (confirm("logout")) {
			Service.logoutUser();
			startMenu();
		}
		else {
			mainMenu();
		}
	}

	private static void createAccountDialogue() {
		System.out.println();
		User user = new User();
		user.setEmail(getUserInput("Email"));
		user.setFirst(getUserInput("First name"));
		user.setLast(getUserInput("Last name"));

		String password = null;
		String reentry = null;
		while (password == null || !password.equals(reentry)) {
			password = getUserInput("Password");
			reentry = getUserInput("Reenter password");

			if (!password.equals(reentry)) {
				System.out.println("Error: Passwords must match");
			}
		}
		user.setPassword(password);
		user.setUserId(DaoTextImpl.nextId());

		String message;
		if ((message = Service.createUser(user)) != null) {
			System.out.println("Error: " + message);
		}
	}

	private static void withdrawDialogue() {
		System.out.println();
		String input = getUserInput("Amount to withdraw");

		try {
			BigDecimal amount = new BigDecimal(input);
			if (confirm("withdraw "+ NumberFormat.getCurrencyInstance().format(amount))) {
				if (amount.compareTo(BigDecimal.ZERO) <= 0) {
					System.out.println("Error: Must be a positive amount");
				}
				else if (amount.compareTo(Service.getCurrentUser().getBalance()) > 0) {
					System.out.println("Error: Insufficient funds");
				}
				else {
					Service.withdraw(amount);
					mainMenu();
				}
			}
		}
		catch (NumberFormatException e) {
			System.out.println("Bad number format");
		}
		for (;;) {
			System.out.println();
			System.out.println("1. Try again");
			System.out.println("2. Return to menu");
			switch (scan.nextLine()) {
			case "1":
				withdrawDialogue();
				break;
			case "2":
				mainMenu();
				break;
			default:
			}
		}
	}

	private static void depositDialogue() {
		System.out.println();
		String input = getUserInput("Amount to deposit");

		try {
			BigDecimal amount = new BigDecimal(input);
			if (confirm("deposit " + NumberFormat.getCurrencyInstance().format(amount))) {
				if (amount.compareTo(BigDecimal.ZERO) <= 0) {
					System.out.println("Error: Must be a positive amount");
				}
				else {
					Service.deposit(amount);
					mainMenu();
				}
			}
		}
		catch (NumberFormatException e) {
			System.out.println("Bad number format.");
		}		
		for (;;) {
			System.out.println();
			System.out.println("1. Try again");
			System.out.println("2. Return to menu");
			switch (scan.nextLine()) {
			case "1":
				depositDialogue();
				break;
			case "2":
				mainMenu();
				break;
			default:
				return;
			}
		}
	}

	private static void viewBalanceDialogue() {
		System.out.println();
		User user = Service.getCurrentUser();
		if (user != null) {
			System.out.println("Current balance: " + NumberFormat.getCurrencyInstance().format(user.getBalance()));
			System.out.println("1. Return to menu");
			for (;;) {
				switch (scan.nextLine()) {
				case "1":
					mainMenu();
					break;
				default:
				}
			}
		}
		else {
			Service.logoutUser();
			startMenu();
		}
	}

	private static void editAccountDialogue() {
		System.out.println();
		System.out.println("Which info would you like to update?");
		System.out.println("1. Email");
		System.out.println("2. Password");
		System.out.println("3. First name");
		System.out.println("4. Last name");
		System.out.println("5. Return to menu");

		for (;;) {
			switch (scan.nextLine()) {
			case "1":
				String email = getUserInput("Email");
				if (confirm("set your email to " + email)) {
					Service.getCurrentUser().setEmail(email);
					Service.updateUser(Service.getCurrentUser());
				}
				editAccountDialogue();
				break;
			case "2":
				String password = null;
				String reentry = null;
				while (password == null || !password.equals(reentry)) {
					password = getUserInput("Password");
					reentry = getUserInput("Reenter password");
		
					if (!password.equals(reentry)) {
						System.out.println("Error: Passwords must match");
						editAccountDialogue();
					}
				}
				Service.getCurrentUser().setPassword(password);
				Service.updateUser(Service.getCurrentUser());
				editAccountDialogue();
				break;
			case "3":
				String first = getUserInput("First name");
				if (confirm("set your first name to " + first)) {
					Service.getCurrentUser().setFirst(first);
					Service.updateUser(Service.getCurrentUser());
				}
				editAccountDialogue();
				break;
			case "4":
				String last = getUserInput("Last name");
				if (confirm("set your last name to " + last)) {
					Service.getCurrentUser().setLast(last);
					Service.updateUser(Service.getCurrentUser());				
				}
				editAccountDialogue();	
				break;
			case "5":
				mainMenu();
				break;
			default:
			}
		}
	}

	private static String getUserInput(String inputName) {
		String input = null;
		while (input == null || "".equals(input)) {
			System.out.print(inputName + ": ");
			input = scan.nextLine();
		}
		return input;
	}

	private static boolean confirm(String message) {
		System.out.print("Are you sure you want to " + message + "? (y/n) ");
		for (;;) {
			String input = scan.nextLine();
			
			if ("y".equals(input)) return true;			
			if ("n".equals(input)) return false;
		}
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
	 */
}
