package com.bank2.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank2.dao.DAO;
import com.bank2.dao.DaoImpl;
import com.bank2.pojos.User;

import static com.bank2.main.RunBank.login;

public class Service {
	static int id;
	DAO dao = new DaoImpl();

	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Login:");
		System.out.println("Username:");
		String username = scan.nextLine().trim();

		System.out.println("Password:");
		String pw = scan.nextLine().trim();

		id = dao.getUserID(username, pw);

		if (id == 0) {
			System.out.println("User doesn't exist, would you like to create one? (Y/N)");
			String acctQ = scan.nextLine().trim().toUpperCase();
			if (acctQ.equals("Y")) {
				System.out.println("Please enter firstname");
				String fn = scan.nextLine().trim();
				System.out.println("Please enter lastname");
				String ln = scan.nextLine().trim();
				dao.addUser(fn, ln, username, pw);
				login = false;
				System.out.println("Rerun program to access new user");
			} else {
				login = false;
				System.out.println("Ok, bye");
			}
		} else {
			login = true;
		}
	}

	public void createSavings() {
		dao.createAccount(id, 2);
	}

	public void createChecking() {
		dao.createAccount(id, 1);
	}

	public void createCredit() {
		dao.createAccount(id, 3);
	}

	public void viewBalance() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Which account would you like a balance of?");
		System.out.println("Enter (1) for Checking");
		System.out.println("Enter (2) for Savings");
		System.out.println("Enter (3) for Credit");
		int typeid = scan.nextInt();
		double balance = dao.getBalance(id, typeid);
		System.out.println("Your Balance is: " + balance);
	}

	public void depositFunds() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Which account would you like to deposit to?");
		System.out.println("Enter (1) for Checking");
		System.out.println("Enter (2) for Savings");
		System.out.println("Enter (3) for Credit");
		int typeid = scan.nextInt();
		System.out.println("How much would you like to deposit?");
		double amt = scan.nextDouble();
		dao.updateBalance(id, typeid, amt);
	}

	public boolean withdrawFunds() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Which account would you like to withdraw from?");
		System.out.println("Enter (1) for Checking");
		System.out.println("Enter (2) for Savings");
		System.out.println("Enter (3) for Credit");
		int typeid = scan.nextInt();
		System.out.println("How much would you like to withdraw?");
		double amt = scan.nextDouble();
		double balance = dao.getBalance(id, typeid);
		if (balance < amt) {
			System.out.println("You don't have enough to cover that withdrawal");
			System.out.println("Your balance is: " + balance);
			return false;
		} else {
			dao.updateBalance(id, typeid, -amt);
			return true;
		}
	}

	public void editAcctInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter new First Name");
		String fn = scan.nextLine().trim();
		System.out.println("Enter new Last Name");
		String ln = scan.nextLine().trim();
		System.out.println("Enter new password");
		String pw = scan.nextLine().trim();
		dao.editUser(fn, ln, pw, id);
	}

	public void deleteAcct() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Are you sure you want to delete your Account? (Y,N)");
		String acctQ = scan.nextLine().trim().toUpperCase();
		if (acctQ.equals("Y")) {
			System.out.println("Which account would you like to close?");
			System.out.println("Enter (1) for Checking");
			System.out.println("Enter (2) for Savings");
			System.out.println("Enter (3) for Credit");
			int typeid = scan.nextInt();
			double balance = dao.getBalance(id, typeid);
			if (balance > 0.0) {
				System.out.println("You should withdraw your balance before closing your account");
			} else {
				dao.deleteAcct(id, typeid);
				System.out.println("Account deleted as requested");
			}
		}
	}
	
	public void transferFunds() {
		boolean success = false;
		success = withdrawFunds();
		if(success) {
			depositFunds();
		}
	}

	public void logout() {
		System.out.println("Logging out, Bye");
		login = false;
	}

}
