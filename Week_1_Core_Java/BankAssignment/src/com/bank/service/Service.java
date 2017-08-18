package com.bank.service;

import com.bank.dao.DAO;
import com.bank.dao.DaoTextImpl;
import com.bank.pojos.User;

import java.math.BigDecimal;
import java.util.*;

public class Service { //The service layer

	
	static DAO test = new DaoTextImpl();
	static boolean unique = true;
	
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
					menu();
			}
			
		}

		
		
		
		
	}
	public static void logout() {
		System.exit(0);
	}
	static void createUser() {
		
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("Enter your first name: ");
		String fn = input.nextLine().trim();
		System.out.println("Enter your last name: ");
		String ln = input.nextLine().trim();
		
	
		System.out.println("Enter your email: ");
		String email = input.nextLine().trim();
	
		
		System.out.println("Create a password: ");
		String pw = input.nextLine().trim();
		
		Integer id = random.nextInt(9999);
		String idString = id.toString();
		BigDecimal bal = new BigDecimal(0.00);
		String balString = bal.toString();
		
		User u = new User(idString,fn,ln,email,pw,balString);
		
		test.addUser(u);
	}
	
//	static void deleteUser() {
//		ArrayList<User> users = test.readUser();
//		Scanner input = new Scanner(System.in);
//		System.out.println("Enter the ID of the person you want deleted");
//		String temp = input.nextLine().trim();
//		for(User u: users) {
//			if(u.getUserID().equals(temp)) {
//				users.clear();
//			}
//		}
//	}
	
//	static void displayUser() {
//		ArrayList<User> users = test.readUser();
//		for(User u: users)
//			System.out.println(u);	
//	}
	static boolean checkEmail(String str) {
		ArrayList<User> users = test.readUser();
		
		for(User u : users) {
			if(u.getEmail().equals(str))
				return true;
			else
				return false;
		}
		return false;
	}
	
	static boolean checkPassword(String str) {
		ArrayList<User> users = test.readUser();
		
		for(User u: users) {
			if(u.getPassWord().equals(str))
				return true;
			else
				return false;
		}
		return false;
	}
	
	static void viewBalance(User u) {
			
		System.out.println(u.getBalance());
		
		
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
	
	static void menu() {
		int choice = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to The Bank! What would you like to do?\n "
				+ "1.View Balance\n"
				+ "2.Deposit\n"
				+ "3.Withdraw\n"
				+ "4.Edit Account\n"
				+ "5.Logout");
		choice = input.nextInt();
		while(choice != 1 && choice != 2 && choice !=3 && choice != 4 && choice !=5) {
			System.out.println("Please enter a valid selection.");
			System.out.println("Welcome to The Bank! What would you like to do?\n "
					+ "1.View Balance\n"
					+ "2.Deposit\n"
					+ "3.Withdraw\n"
					+ "4.Edit Account\n"
					+ "5.Logout");
			choice = input.nextInt();
		}
//		switch(choice) {
//		case(1):
//			viewBalance();
//		case(2):
//			deposit();
//		case(3):
//			withdraw();
//		case(4):
//			editUser();
//		case(5):
//			logout();
//	}
		}
	}
	

