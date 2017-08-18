package com.bank.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.dao.DAO;
import com.bank.dao.DaoTextImpl;
import static com.bank.main.RunBank.login;
import com.bank.pojos.User;

public class Service {
//login functionality
//what do you want to do functionality
// 
	static int id;
	DAO dao = new DaoTextImpl();

	public void createAcct(User user, String id) {
		dao.addUser(user);
		dao.updateID(id);
		System.out.println("New account created");
	}
	
	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Login:");
		System.out.println("Enter your first name");
		String fn = scan.nextLine().trim();
		
		System.out.println("Enter your last name");
		String ln = scan.nextLine().trim();
		
		id = dao.getUserID(fn, ln);

		if(id == 0) {
			System.out.println("Account doesn't exist, would you like to create one? (Y/N)");
			String acctQ = scan.nextLine().trim().toUpperCase();
			System.out.println(acctQ);
			if(acctQ.equals("Y")) {
				System.out.println("Please enter email");
				String email = scan.nextLine().trim();
				System.out.println("Please enter password");
				String pw = scan.nextLine().trim();
				int id = dao.getNextID();
				User user = new User(id, fn, ln, email, pw, 0);
				createAcct(user, String.valueOf(id));
				login = true;
			} else {
				login = false;
				System.out.println("Ok, bye");
			}
		} else {
			login = true;
		}
	}
	
	public void logout() {
		System.out.println("Logging out, Bye");
		login = false;
	}

	public void withdrawFunds() {
		Scanner scan = new Scanner(System.in);
		System.out.println("How much would you like to withdraw?");
		String amt = scan.nextLine().trim();
		ArrayList<User> user = new ArrayList();
		user = dao.getUser(id);
		for(User u : user) {
			if(u.getBalance() < Double.parseDouble(amt)) {
				System.out.println();
				System.out.println("You don't have enough to cover that withdrawl");
				System.out.println("Your balance is: " + u.getBalance());
			}
		}
	}
	
	public void depositFunds() {
		Scanner scan = new Scanner(System.in);
		System.out.println("How much would you like to deposit?");
		String amt = scan.nextLine().trim();
		ArrayList<User> user = new ArrayList();
		user = dao.getUser(id);
		for(User u : user) {
			
		}
		
	}
	
	public void viewBalance() {
		ArrayList<User> user = new ArrayList();
		user = dao.getUser(id);
		for(User u : user) {
			System.out.println();
			System.out.println("Your balance is: " + u.getBalance());
		}
	}
	
	public void editAcctInfo() {
		
	}
	
}