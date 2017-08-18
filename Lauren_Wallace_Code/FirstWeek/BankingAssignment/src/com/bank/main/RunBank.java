package com.bank.main;

import java.util.Scanner;

import com.bank.dao.DAOTextImpl;
import com.bank.service.Service;

/*
	 * Requirements: As a user I can:
	 * - create an account
	 * - login
	 * - logout
	 * - withdraw/deposit funds into balance
	 * - view my* account balance
	 * - edit my* information
	 * 
	 * Tech Specs
	 * - core java, file I/O
	 */

public class RunBank {

	static Service bankService;
	static String loggedIn = " ";
	static Scanner in;
	static String choice;
	static String choice2;
	
	//Implementation to actually run the bank application
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		bankService = new Service();
		
		options();
		
	}
	
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
		System.out.println("3 - changer your username");
		System.out.println("4 - change your password");
		System.out.println("5 - change your last name");
	}
	
	static void printBalanceMenu() {
		System.out.println("The balance changes available through this console are:");
		System.out.println("1 - add money to your account");
		System.out.println("2 - take money out of your account");
	}
	
	static void options() {
		if (loggedIn.equals("")) {
			printMainMenu();
			choice = in.nextLine();
			startChoice(choice);
		}
		else {
			printLoginMenu();
			choice2 = in.nextLine();
			reoccuringChoice(choice);
		}
		options();
	}
	
	//choice that should only be made once 
	static void startChoice(String choice) {
		
		switch(choice) {
		case "1": bankService.addUser(in);
				  bankService.loginUser(in);
			      break;
		case "2": bankService.loginUser(in);
		   		  break;
		}
	}
	
	static void logoutUser() {
		loggedIn = "";
	}
	
	static void reoccuringChoice(String choice) {
		
		String eChoice;
		
		switch(choice) {
		case "1": logoutUser();
				  break;
		case "2": bankService.viewUser();
		   		  break;
		case "3": printEditMenu();
				  eChoice = in.nextLine();
			  	  editChoice(eChoice);
			  	  break;
		}
	}
	
	static void editChoice(String str) {
		
		String newStr;
		
		switch(str) {
		case "1": System.out.println("Enter new firstname:");
				  newStr = in.nextLine().toLowerCase();
				  bankService.editUserFName(newStr);
				  break;
		case  "2": System.out.println("Enter new lastname:");
				   newStr = in.nextLine().toLowerCase();
				   bankService.editUserLName(newStr);
				   break;
		case  "3": System.out.println("Enter new username:");
				   newStr = in.nextLine().toLowerCase();
				   bankService.editUserName(newStr);
				   break;
		case  "4": System.out.println("Enter new password:");
				   newStr = in.nextLine().toLowerCase();
				   bankService.editUserPass(newStr);
				   break;
		case  "5": printBalanceMenu();
				   newStr = in.nextLine().toLowerCase();
				   balanceChoice(newStr);
				   break;
		}
	}
		
	static void balanceChoice(String choice) {
		
		double bChange;
		
		switch(choice) {
		case       "1" : System.out.println("Enter amount to deposit:");
						 bChange = in.nextDouble();
						 bankService.editBalance(bChange, choice);
						 break;
		case        "2": System.out.println("Enter amount to deposit:");
		 				 bChange = in.nextDouble();
		                 bankService.editBalance(bChange, choice);
		                 break;
		}
	}

}
