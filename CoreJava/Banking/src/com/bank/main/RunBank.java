package com.bank.main;

import java.math.BigDecimal;
import java.util.Scanner;

import com.bank.pojos.User;
import com.bank.service.Service;

public class RunBank {
	static int first =0;
	static User thisUser =null;
	private static Scanner scan;

	//implementation to actually run bank application
	public static void main(String[] args) {
		Service bankService = new Service();
		scan = new Scanner(System.in);
		System.out.println("Hello. Welcome to The Bank. Do you already have an account with us?");
		String input = scan.nextLine();
		if(input.trim().equalsIgnoreCase("YES") || input.trim().equalsIgnoreCase("Y")) {
			thisUser = login();
		}
		else {
			thisUser = createAccount();
		}
		giveOptions();
	}
	//The following two methods are primarily used to give the user options
	private static void giveOptions() {
		System.out.println("What woud you like to do today?");
		System.out.println("To withdraw money, enter 1");
		System.out.println("To deposit money, enter 2");
		System.out.println("To view current balance, enter 3");
		System.out.println("To edit information such as name or password, enter 4");
		System.out.println("To logout, enter 5");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();

		switch(input) {
		case("1"):
			withdraw();
		break;
		case("2"):
			deposit();
		break;
		case("3"):
			viewbalance();
		break;
		case("4"):
			editInfo();
		break;
		case("5"):
			logout();
		break;
		}	
	}
	private static void editInfo() {
		System.out.println("What would you like to change?");
		System.out.println("To change your password, enter 1");
		System.out.println("To change your name, enter 2");
		System.out.println("To change your email address, enter 3");
		System.out.println("To delete your account, enter 4");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		switch(input) {
		case("1"):
			changePassword();
		break;
		case("2"):
			changeName();
		break;
		case("3"):
			changeEmail();
		break;
		case("4"):
			deleteAccount();
			break;
		}
	}

	private static void deleteAccount() {
		Service.deleteAccount(thisUser);
	}
	private static void changeEmail() {
		//in order to change their unique email, the user must enter password
		//for security
		if(validateUser(thisUser)!=null) {
			System.out.println("Enter new email");
			Scanner scan = new Scanner(System.in);
			String email = scan.nextLine();
			if(Service.login(email)==null) {
				thisUser.setEmail(email);
				Service.update(thisUser);
				System.out.println("Email successfully changed to "+email);
				giveOptions();
			}
		}		
	}

	private static void changeName() {
		System.out.println("Enter new name (full name)");
		Scanner scan = new Scanner(System.in);
		String names = scan.nextLine();
		String[] name = names.trim().split(" ");
		thisUser.setFirstname(name[0]);
		thisUser.setLastname(name[1]);
		Service.update(thisUser);
		System.out.println("Name successfully changed to "+ names);
		giveOptions();
	}

	private static void changePassword() {
		System.out.println("Enter new password");
		Scanner scan = new Scanner(System.in);
		String password = scan.nextLine();
		thisUser.setPassword(password);
		Service.update(thisUser);
		System.out.println("Password successfully changed to "+ password);
		giveOptions();
	}

	private static void viewbalance() {
		System.out.println(thisUser.getBalance());
		giveOptions();
	}

	private static void deposit() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter amount you wish to deposit");
		double amount = scan.nextDouble();

		Service.deposit(thisUser, amount);
		System.out.println(amount+ " successfully deposited");
		giveOptions();
	}

	private static void withdraw() {
		System.out.println("Please enter amount you wish to withdraw");
		Scanner scan = new Scanner(System.in);
		double amount = scan.nextDouble();
		if(Service.withdraw(thisUser, amount)) {	
			System.out.println(amount+" withdrawn from account.");
		}
		else {
			System.out.println("Insuficient funds.");
		}

		giveOptions();

	}

	static User login() {
		System.out.println("Please enter email");
		scan = new Scanner(System.in);
		String username = scan.nextLine();
		this.user = Service.login(username);
		//bankService.login returns the Use associated with this email if it exists
		//it returns null if it does not exist
		if(currentUser!=null) {
			System.out.println("Welcome back "+ currentUser.getFirstname());
			return validateUser(currentUser);
		}
		else {
			System.out.println("Sorry, this username does not exist, please try again, or enter \"quit\" to quit");
			login();
		}
		return null;
	}

	static User validateUser(User currentUser) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter password, or to quit, enter quit");
		String tryPassword = scan.nextLine();
		//if the user enters quit, it will log them out, if not the method will proceed as usual
		if(tryPassword!="quit") {
			//bankService.checkPassword just checks that the password is the same
			//as the User's password
			if(Service.checkPassword(currentUser, tryPassword)) {
				return currentUser;
			}
			else {
				System.out.println("Sorry, password incorrect, please try again.");
				//if the password is incorrect, the user enters a loop that can only
				//be exited by entering the correct password or entering quit
				validateUser(currentUser);
			}
		}
		if(tryPassword=="quit") {
			logout();}
		return null;
	}

	static User createAccount() {
		Scanner scan = new Scanner(System.in);
		User user;
		System.out.println("Enter an email address");
		String newUsername = scan.nextLine();
		//bankService.login returns a null if the username does not exist
		if(Service.login(newUsername)!=null) {

			System.out.println("I'm sorry, this username already exists.");
			//if this username already exists,
			createAccount();
			//return null;
		}
		else {
			System.out.println("Enter your first name");
			String newName = scan.nextLine();

			System.out.println("Enter your last name");
			String newLast = scan.nextLine();

			System.out.println("Enter a password for this account");
			String newPassword = scan.nextLine();

			user = Service.createAccount(newName, newLast, newUsername, newPassword);
			return user;
		}	
		login();
		return null;
	}
	
	private static void logout() {
		System.out.println("Thank you, come back soon");
		thisUser = null;
	}
}
