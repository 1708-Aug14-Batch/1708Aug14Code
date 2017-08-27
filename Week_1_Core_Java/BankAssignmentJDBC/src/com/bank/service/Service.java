package com.bank.service;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.bank.dao.DAO;
import com.bank.dao.DAOImpl;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;

public class Service {
	
	static DAO test = new DAOImpl();
	
	public void login() {
		
		String email;
		String pass = "";
		boolean passCheck = false;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Welcome to the Bank!\nPlease enter an email:\n");
		email = input.nextLine().trim();
		boolean check = checkEmail(email);
		while(check != true) {
			System.out.println("Email not found. Please enter valid email: ");
			email = input.nextLine().trim();
			check = checkEmail(email);
		}
		if(check == true) {
			System.out.println("Please enter your password:");
			pass = input.nextLine().trim();
			passCheck = checkPassword(pass);
			while(passCheck != true) {
				System.out.println("Password Invalid. Please enter password:");
				pass = input.nextLine().trim();
				passCheck = checkPassword(pass);
		}
			if(passCheck == true) {
				if(pass.equals("admin"))
					adminMenu();
				else
					menu(email);
			}
			
		}
		
		
		
		
	
	}
	
	
	static boolean checkEmail(String str) {
		ArrayList<User> users = test.readUser();
		
		for(User u : users) {
			
			if(u.getEmail().equals(str))
				return true;
		}
		return false;
	}
	
	static boolean checkPassword(String str) {
		ArrayList<User> users = test.readUser();
		
		for(User u: users) {
			
			if(u.getPassword().equals(str))
				return true;

		}
		return false;
	}
	
	static void adminMenu() {
		int choice = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Good Day System Admin. Would you like to do the following?\n"
				+ "1.Add User\n"
				+ "2.Logout");
		choice = input.nextInt();
		while(choice != 1 && choice != 2 && choice != 3) {
			System.out.println("Invalid selection. Please choose again:\n"
					+ "1.Add User\n"
					+ "2.Logout");
			choice = input.nextInt();
		}
		if(choice == 1) {
			createUser();
		}
		else if(choice == 2) {
			logout();
		}
	}
	
	static void menu(String str) {
		int choice = 0;
		Scanner input = new Scanner(System.in);
		String userInfo = str;
		ArrayList<User> users = test.readUser();
		
		for(User u: users) {
			if(u.getEmail().equals(str)) {
		System.out.println("Welcome to The Bank " + u.getFirstname() + " " + u.getLastname() + "! What would you like to do?\n"
				+ "1.Add Account\n"
				+ "2.View Balance\n"
				+ "3.Deposit\n"
				+ "4.Withdraw\n"
				+ "5.Edit Account\n"
				+ "6.Logout");
		choice = input.nextInt();
		while(choice != 1 && choice != 2 && choice !=3 && choice != 4 && choice !=5 && choice != 6) {
			System.out.println("Please enter a valid selection.");
			System.out.println("Welcome to The Bank " + u.getFirstname() + " " + u.getLastname() + "! What would you like to do?\n"
					+ "1.Add Account\n"
					+ "2.View Balance\n"
					+ "3.Deposit\n"
					+ "4.Withdraw\n"
					+ "5.Edit Account\n"
					+ "6.Logout");
			choice = input.nextInt();
		}
			}
		}
		switch(choice) {
		case(1):
			AddAccount(userInfo);
		case(2):
			viewBalance(userInfo);
//		case(3):
//			deposit(userInfo);
//		case(4):
//			withdraw(userInfo);
//		case(5):
//			editUser(userInfo);
//		case(6):
//			logout();
	}
		}
	
	static void createUser() {
		
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("Enter the first name: ");
		String fn = input.nextLine().trim();
		System.out.println("Enter the last name: ");
		String ln = input.nextLine().trim();
		
	
		System.out.println("Enter the email: ");
		String email = input.nextLine().trim();
		boolean check = alreadyExists(email);
		while(check == true) {
			System.out.println("This email already exists, please input another: ");
			email = input.nextLine().trim();
			check = alreadyExists(email);
		}
		
		System.out.println("Create a password: ");
		String pw = input.nextLine().trim();
		
	
		
		
		
		test.addUser(fn,ln,email,pw);
		adminMenu();
	}

	static boolean alreadyExists(String em) {
		ArrayList<User> users = test.readUser();
		
		for(User u : users) {
			
			if(u.getEmail().equals(em))
				return true;
		}
		return false;
		
	}
	
	

	
	static void AddAccount(String str) {
		ArrayList<User> users = test.readUser();
	
		ArrayList<AccountType> acctType = test.readAccountType();
		Scanner input = new Scanner(System.in);
		int choice, accountNum = 0;
		
		System.out.println("What kind of Account would you like to make? \n"
				+ "1. Checking\n"
				+ "2. Savings\n"
				+ "3. Credit\n");
		choice = input.nextInt();
		
		if(choice == 1)
			accountNum = 1;
		else if (choice == 2)
			accountNum = 2;
		else if (choice == 3)
			accountNum = 3;
		
		for(User u: users) {
			
			if(u.getEmail().equals(str)) {
				
				test.createAccount(u,accountNum);
				System.out.println("Account Successfully Created!");
				
			}
		}
		menu(str);
		
	}
	
	
	static void viewBalance(String str) {
		ArrayList<User> users = test.readUser();
		ArrayList<Account> acct = test.readAccount();
		for(User u: users) {
			for(Account a: acct) {
				if(u.getEmail().equals(str))
					System.out.println("Your total balance is $" + a.getBalance());
			}

		}
		menu(str);
	}
	
	
	
	
//	static void deposit(String str) {
//		ArrayList<User> users = test.readUser();
//		ArrayList<Account> accounts = test.readAccount()
//		int money = 0;
//		
//		Scanner input = new Scanner(System.in);
//		System.out.println("How much money are you depositing today? ");
//		money = input.nextInt();
//		while(money <= 0) {
//			System.out.println("Please enter an amount higher than 0");
//			System.out.println("How much money are you depositing today? ");
//			money = input.nextInt();
//		}
//		for(User u: users) {
//			for(Account a: accounts)
//			if(u.getEmail().equals(str)) {
//				money += u.getBalance();
//				u.setBalance(money);
//				test.editUser(users);
//				System.out.println("Your total balance after deposit is $" + u.getBalance());
//			}
//		}
//		menu(str);
//	}
	
	
	
	
	static void logout() { //Simple logout function for logging out.
		System.exit(0);
	}
	
	/*
	 * The following is for the admin to create a user in the system.
	 * It will have the admin input the first name, last name, email, and password.
	 * Since its a new user we assume that they start off with a 0 dollar balance.
	 * The ID is a randomly generated 4 digit number between 0 to 9999
	 * The new user is appended to the text file, and finally the admin is sent back to the admin menu
	 */
	
	
}
