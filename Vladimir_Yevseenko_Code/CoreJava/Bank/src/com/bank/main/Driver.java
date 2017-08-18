package com.bank.main;

import java.util.Scanner;

import com.bank.pojos.Field;
import com.bank.service.BankService;

public class Driver {
	
	private static final String path = "src/com/bank/data/users.txt";
	private static BankService service = new BankService(path);
	private static Scanner s;
	
	public static void main(String[] args) {
		boolean running = true;
		s = new Scanner(System.in);
		
		System.out.println("Welcome to the banking app!");
		while (running) {
			System.out.println("\nWhat would you like to do?");
			System.out.println("L - login C - create new user Q - quit");
			switch (s .nextLine()) {
				case "L": attemptLogin(); break;
				case "C": createNewUser(); break;
				case "Q": running = false; break;
				default: invalidInput(); break;
			}
		}
		
		s.close();
		service.commit();
	}
	
	public static void attemptLogin() {
		System.out.print("\nEnter email: ");
		String email = s.nextLine();
		System.out.print("Enter password: ");
		String password = s.nextLine();
		if (!service.login(email, password)) {
			System.out.println("\nInvalid email/password.\n");
		} else {
			System.out.println("\nLogin successful.\n");
			handleUser();
		}
	}
	
	public static void handleUser() {
		while (true) {
			System.out.println("What would you like to do?");
			System.out.println("B - check balance D - deposit W - withdraw C - change info "
					+ "RM - delete user Q - logout");
			String line = s.nextLine();
			switch (line) {
				case "Q": return;
				case "D": deposit(); break;
				case "W": withdraw(); break;
				case "C": changeInfo(); break;
				case "RM": deleteUser(); return; 
				case "B": service.displayBalance(); break;
				default: invalidInput();
			}
		}
	}
	
	public static void deposit() {
		System.out.println("\nHow much would you like to deposit?");
		String funds = s.nextLine();
		try {
			Float.parseFloat(funds);
		} catch (NumberFormatException ex) {
			invalidInput();
			return;
		}
		service.deposit(funds);
	}
	
	public static void withdraw() {
		System.out.println("\nHow much would you like to withdraw?");
		String funds = s.nextLine();
		try {
			Float.parseFloat(funds);
		} catch (NumberFormatException ex) {
			invalidInput();
			return;
		}
		service.withdraw(s.nextLine());
	}
	
	public static void changeInfo() {
		System.out.println("\nWhich field would you like to modify? ");
		System.out.println("F - first name L - last name E - email P - password Q - back");
		String in = s.nextLine();
		if (in.equals("Q"))
			return;
		Field field = Field.parseField(in);
		System.out.print("Enter new " + field.toString() + ": ");
		service.modify(field, s.nextLine());
		System.out.println("\nChange successful\n");
	}
	
	public static void deleteUser() {
		service.deleteUser();
		System.out.println("\nUser successfully deleted, logged out.\n");
	}
	
	public static void createNewUser() {
		System.out.print("\nFirst: ");
		String first = s.nextLine();
		System.out.print("Last: ");
		String last = s.nextLine();
		System.out.print("Email: ");
		String email = s.nextLine();
		System.out.print("Password: ");
		String password = s.nextLine();
		service.createNewUser(first, last, email, password);
	}

	
	public static void invalidInput() {
		System.out.println("\nInvalid input.\n");
	}
}
