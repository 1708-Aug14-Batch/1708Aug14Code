package com.ex.run;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Scanner;

import com.ex.dao.DAOImpl;
import com.ex.pojos.Account;
import com.ex.pojos.User;
import com.ex.service.Service;

/*
 * This class interacts with the console to retrieve user input
 * This class creates a Service object that creates a DAOImpl object
 * This class passes a Scanner object to Service & DAOImpl 
 * where needed; when the user must make another choice
 * 
 * 
 */

public class BankRun {
	
	static Service bankService;
	static Scanner in;
	static String email;
	static String password;
	static boolean loggedIn; //false for not logged in; true for logged in
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		bankService = new Service();
		
		options();

	}
	
	/*
	 * Menu printing methods start on line 42
	 * and end on line 68
	 */
	static void printMainMenu() {
		System.out.println("The services available through this console are:");
		System.out.println("1 - create");
		System.out.println("2 - login");
	}
	
	//these are options user has once logged in
	static void printLoginMenu() {
		System.out.println("The services available through this console are:");
		System.out.println("1 - logout");
		System.out.println("2 - view your account information");
		System.out.println("3 - edit your account information"); 
	}
	
	//these are options user has for edit once logged in
	static void printEditMenu() {
		System.out.println("The edits available through this console are:");
		System.out.println("1 - change your first name");
		System.out.println("2 - change your last name");
		//System.out.println("3 - change your email");
		System.out.println("3 - change your password");
		System.out.println("4- change your balance");
		System.out.println("5 - close your chosen account");
}
	
	static void printBalanceMenu() {
		System.out.println("The balance changes available through this console are:");
		System.out.println("1 - add money to your account");
		System.out.println("2 - take money out of your account");
		System.out.println("3 - transfer funds from your accounts");
	}
	
	// Logs in a user by taking the user input & calling doesUserExist to
	// setup
	public static void loginUser() {

		System.out.println("Enter your email:");
		email = in.next();
		//System.out.println("Enter your password:");
		//password = in.next();
		if(bankService.getDao().doesUserWithEmailExist(email)) {
			loggedIn = true;
		}
	}
	
	static void logoutUser() {
		loggedIn = false;
	}
	
	static boolean doesUserExist(String email, String password) {

		if(bankService.getDao().doesUserWithEmailExist(email)) {
			return true;
		}
		return false;
	}
	
	/*
	 * Runs the options available to a user 
	 * based on loggedIn status
	 */
	static void options() {
		String choice;
		
		if (loggedIn) {
			printLoginMenu();
			choice = in.next();
			reoccuringChoice(choice);
		}
		else {
			printMainMenu();
			choice = in.next();
			startChoice(choice);
		}
		options();
	}
	
	//choice that should only be made once 
	static void startChoice(String choice) {
		//1 - create user; 2 - login 
		switch(choice) {
		case "1": addUser();
			      break;
		case "2": loginUser();
		   		  break;
		}
	}
	
static void editChoice(String str) {
		
		String newStr;
		
		switch(str) {
		case "1": System.out.println("Enter new firstname:");
				  newStr = in.next();
				  bankService.editUserFName(email, newStr);
				  break;
		case  "2": System.out.println("Enter new lastname:");
				   newStr = in.next();
				   bankService.editUserLName(email, newStr);
				   break;
		//case  "3": System.out.println("Enter new email:");
		//		   newStr = in.nextLine();
		//		   bankService.editUserEmail(email, newStr);
		//		   break;
		case  "3": System.out.println("Enter new password:");
				   newStr = in.next();
				   bankService.editUserPass(email, newStr);
				   break;
		case  "4": printBalanceMenu();
				   newStr = in.next();
				   balanceChoice(newStr);
				   break;
		case "5": System.out.println("Enter email of account to close:");
				  newStr = in.next();
				  bankService.closeAccount(newStr);
				  break;
		}
		newStr = "";
	}

	static void balanceChoice(String choice) {

		double bChange;
		String rFundsEmail;
		String aFundsEmail;

		switch (choice) {
		case "1":
			System.out.println("Enter amount to deposit:");
			bChange = in.nextDouble();
			bankService.editBalance(bChange, email, choice);
			break;
		case "2":
			System.out.println("Enter amount to withdraw:");
			bChange = in.nextDouble();
			bankService.editBalance(bChange, email, choice);
			break;
		case "3":
			System.out.println("Enter the email of the account to move funds from:");
			rFundsEmail = in.next();
			System.out.println("Enter the email of the account to put funds into:");
			aFundsEmail = in.next();
			System.out.println("Enter the email of the account to put funds into:");
			bChange = in.nextDouble();
			//transaction method to move the funds
			bankService.transferFunds(bChange, rFundsEmail, aFundsEmail);
		}
	}
	
	static void reoccuringChoice(String choice) {

		String eChoice;

		switch (choice) {
		case "1":
			logoutUser();
			break;
		case "2":
			bankService.getDao().getUserAccounts(bankService.getDao().setUserInfo(email));
			break;
		case "3":
			printEditMenu();
			eChoice = in.next();
			editChoice(eChoice);
			break;
		}
	}
	
	//getting the user's creation items to have Service 
	//provide them to the DAOImpl object
	//tested & works
    public static void addUser(){
		
		System.out.println("Enter your first name:");
		String fn = in.next().trim();
		
		System.out.println("Enter your last name:");
		String ln = in.next().trim();
		
		System.out.println("Enter your email:");
		String email = in.next().trim();
		
		System.out.println("Enter your password:");
		String password = in.next().trim();
		
		bankService.getDao().addUser(fn, ln, email, password);
    }
}
    

// Test to see if dao.addUser works & it does
// int x = dao.addUser("Genesis", "Bonds", "gBonds@gmail.com", "gBonds");
// System.out.println(x);

// Test get all users from the bank DB & it works
// ArrayList<User> list = dao.getAll();
// for(User ex: list) {
// System.out.println(ex.toString());
// }

// Test get all accounts from the bank DB not working
// nullpointerexception
// ArrayList<Account> alist = dao.getAllAccs();
// for(Account ac: alist) {
// System.out.println(ac.toString());
// }
