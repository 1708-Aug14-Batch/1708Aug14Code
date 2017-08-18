package com.bank.service;

import java.util.Scanner;

import com.bank.dao.Dao_TextImplementation;
import com.bank.pojos.User;

public class Service {

	private Dao_TextImplementation dao = new Dao_TextImplementation();
	private User user = null;
	private int AccountAmount = 0;
	private boolean LoggedOn = false;
	
	public Service() {
		
	}
	
	public void manageAccount(Scanner scan) {
		// TODO add account options
		LoggedOn = true;
		System.out.println("You have logged on!");
		System.out.println("Current Information: " + user.toString());
		while(LoggedOn) {
			System.out.println("Manage Funds / Display Info / Edit Info / Delete Account / Logout (1/2/3/4/5): ");
			switch(scan.nextLine()) {
			case "1":
				manageFunds(scan);
				break;
			case "2":
				System.out.println("Current Information: " + user.toString());
				break;
			case "3":
				editInfo(scan);
				break;
			case "4":
				if(deleteAccount(scan)) {
					LoggedOn = false;
				}
				break;
			case "5":
				LoggedOn = false;
				System.out.println("You have logged out!");
				break;
			default:
				System.out.println("Not Valid input, Please try again.");
				break;
			}
		}
	}
	
	private void manageFunds(Scanner scan) {
		boolean edited = false;
		boolean manFunds = true;
		while(manFunds) {
			System.out.println("Deposit / Withdraw / Back to menu (1/2/3): ");
			switch(scan.nextLine()) {
			case "1":
				System.out.println("How Much do you want to Deposit: ");
				try {
					user.setBalance(user.getBalance() + Double.parseDouble(scan.nextLine()));
					System.out.println("new Balance: " + user.getBalance());
					edited = true;
				}
				catch(NumberFormatException e) {
					System.out.println("Not a valid number, returning to menu.");
				}
				break;
			case "2":
				System.out.println("How Much do you want to Withdraw: ");
				try {
					user.setBalance(user.getBalance() - Double.parseDouble(scan.nextLine()));
					System.out.println("new Balance: " + user.getBalance());
					edited = true;
				}
				catch(NumberFormatException e) {
					System.out.println("Not a valid number, returning to menu.");
				}
				break;
			case "3":
				manFunds = false;
				break;
			default:
				System.out.println("Not Valid input, Please try again.");
				break;
			}
		}
		if(edited) {
			dao.editUser(user);
		}
	}
	
	private void editInfo(Scanner scan) {
		boolean edited = false;
		while(true) {
			System.out.println("What do you want to change?\n");
			System.out.println("Username / Password / First Name / Last Name / Back to menu (1/2/3/4/5): ");
			switch(scan.nextLine()) {
			case "1":
				System.out.println("New Username: ");
				user.setUsername(scan.nextLine());
				edited = true;
				break;
			case "2":
				System.out.println("New Password: ");
				user.setPassword(scan.nextLine());
				edited = true;
				break;
			case "3":
				System.out.println("New First Name: ");
				user.setFirstname(scan.nextLine());
				edited = true;
				break;
			case "4":
				System.out.println("New Last Name: ");
				user.setLastname(scan.nextLine());
				edited = true;
				break;
			case "5":
				if(edited) {
					dao.editUser(user);
				}
				return;
			default:
				System.out.println("Not valid Input, please try again.");
				break;
			}
		}
	}
	
	private boolean deleteAccount(Scanner scan) {
		while(true) {
			System.out.println("Are you sure: (Y = 1 / N = 2)");
			switch(scan.nextLine()) {
			case "1":
				dao.deleteUser(user.getId());
				System.out.println("Your account has been deleted.");
				return true;
			case "2":
				System.out.println("Your account has not been deleted.");
				return false;
			default:
				System.out.println("Not Valid input, Please try again.");
				break;
			}
		}
	}
	
	public boolean attemptLogin(String username, String password) {
		int tempID = -1;
		if((tempID = dao.getUserID(username)) >= 0) {
			user = dao.getUser(tempID);
			if(user != null && (user.getPassword() == password || user.getPassword().equals(password))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkAccounts(String username) {
		if(dao.getUsername(username)) {
			return true;
		}
		return false;
	}
	
	public void createUser(String firstname, String lastname, String username, String password, double balance) {
		AccountAmount = dao.getAccountAmount();
		user = new User(AccountAmount, firstname, lastname, username, password, balance);
		dao.addUser(user);
	}
	
}
