package com.bank.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

import com.bank.dao.DAOsql;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;

enum Operation {
	LOGIN, LOGOUT, CREATE_USER, CREATE_ACCT,
	UPDATE_BAL, VIEW_BAL, EDIT_DETAILS,
	TRANSFER_FUNDS, CLOSE_ACCT,
	INIT, MAIN, RUNNING, SHUTDOWN
}

public class Service {
	
	private DAOsql dao = new DAOsql();
	private Operation op = Operation.INIT;
	
	User login_or_new() {
		op = Operation.MAIN;
		
		Scanner scan = new Scanner(System.in);
		int val = -1;
		while (val < 1 || val > 7) {
			System.out.println("(1) Login\n"
							 + "(2) New User\n"
							 + "(3) Quit");
			val = Integer.parseInt(scan.nextLine());
		}
		
		User u = null;
		switch (val)
		{
		case 1:
			u = login();
			break;
		case 2:
			u = createUser();
			break;
		case 3:
			break;
		}		
		return u;	
	}
	
	User login() {
		op = Operation.LOGIN;
		
		//TODO: Possibly Loop if password is wrong. Ask to create new account if email isn't found?
		Scanner scan = new Scanner(System.in);
		System.out.println("Email:");
		String email = scan.nextLine();
		System.out.println("Password:");
		String password = scan.nextLine();
	
		return dao.getUser(email, password);
	}
	
	User createUser() {
		op = Operation.CREATE_USER;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Firstname:");
		String fn = scan.nextLine();
		System.out.println("Lastname:");
		String ln = scan.nextLine();
		System.out.println("Email:");
		String email = scan.nextLine();
		System.out.println("Password:");
		String password = scan.nextLine();	
		System.out.println("Account Type:\n"
						 + "(1) Checking\n"
						 + "(2) Savings\n"
						 + "(3) Credit");
		String type = scan.nextLine();
		
		User tmpUser = new User(fn, ln, email, password);
		tmpUser.setId(dao.addUser(tmpUser));
		if (tmpUser.getId() == -1)
			return null;
		AccountType tmpType = new AccountType(Integer.parseInt(type));
		Account tmpAcct = new Account(tmpType, tmpUser);
		dao.addAccount(tmpAcct);
		return tmpUser;
	}
	
	void createAccount(User u) {
		op = Operation.CREATE_ACCT;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Account Type:\n"
				 + "(1) Checking\n"
				 + "(2) Savings\n"
				 + "(3) Credit");
		String type = scan.nextLine();
		AccountType tmpType = new AccountType(Integer.parseInt(type));
		Account tmpAcct = new Account(tmpType, u);
		dao.addAccount(tmpAcct);
	}
	
	void updateBalance(User u) {
		
		ArrayList<Account> accts = dao.getAllAccounts(u);
		if (accts.isEmpty()) {
			System.out.println("You have no accounts currently open.");
			return;
		}
		ArrayList<Integer> acctIDs = new ArrayList<Integer>();
		for (Account a : accts) {
			acctIDs.add(a.getId());
			System.out.println(a.toString());
		}
		Scanner scan = new Scanner(System.in);
		int id = -1;
		while (!acctIDs.contains(id))
		{
			System.out.println("Select account ID to update it's balance: ");
			id = Integer.parseInt(scan.nextLine());
		}
		System.out.println("Transfer Amt:");
		BigDecimal amt = new BigDecimal(scan.nextLine());
		dao.setBalance(u, id, amt);
	}
	
	void viewBalance(User u) {
		
		ArrayList<Account> accts = dao.getAllAccounts(u);
		if (accts.isEmpty()) {
			System.out.println("You have no accounts currently open.");
			return;
		}
		ArrayList<Integer> acctIDs = new ArrayList<Integer>();
		for (Account a : accts) {
			acctIDs.add(a.getId());
			System.out.println(a.toString());
		}
	}
	
	void editDetails(User u) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Firstname:");
		String fn = scan.nextLine();
		System.out.println("Lastname:");
		String ln = scan.nextLine();
		System.out.println("Email:");
		String email = scan.nextLine();
		System.out.println("Password:");
		String password = scan.nextLine();
		
		u.setFirstname(fn);
		u.setLastname(ln);
		u.setEmail(email);
		u.setPassword(password);
		
		dao.editUser(u.getId(), u);
	}
	
	void transferFunds(User u) {
		
		ArrayList<Account> accts = dao.getAllAccounts(u);
		if (accts.size() < 2) {
			System.out.println("You must have at least two accounts open to transfer funds.");
			return;
		}
		ArrayList<Integer> acctIDs = new ArrayList<Integer>();
		for (Account a : accts) {
			acctIDs.add(a.getId());
			System.out.println(a.toString());
		}
	
		Scanner scan = new Scanner(System.in);
		int from = -1;
		while (!acctIDs.contains(from))
		{
			System.out.println("Select account ID to transfer FROM: ");
			from = Integer.parseInt(scan.nextLine());
		}
		int to = -1;
		while (!acctIDs.contains(to))
		{
			System.out.println("Select account ID to transfer TO: ");
			to = Integer.parseInt(scan.nextLine());
		}
		System.out.println("Transfer Amt:");
		BigDecimal amt = new BigDecimal(scan.nextLine());
		dao.setBalance(u, from, amt.negate());
		dao.setBalance(u, to, amt);
	}
	
	void closeAccount(User u) {
		
		ArrayList<Account> accts = dao.getAllAccounts(u);
		if (accts.isEmpty()) {
			System.out.println("You have no accounts currently open.");
			return;
		}
		ArrayList<Integer> acctIDs = new ArrayList<Integer>();
		for (Account a : accts) {
			acctIDs.add(a.getId());
			System.out.println(a.toString());
		}
	
		Scanner scan = new Scanner(System.in);
		int id = -1;
		while (!acctIDs.contains(id))
		{
			System.out.println("Select account ID to close: ");
			id = Integer.parseInt(scan.nextLine());
		}
		dao.closeAccount(id);
	}
	
	User logout() {	return null; }
	
	void getAction() {
		op = Operation.RUNNING;
		
		Scanner scan = new Scanner(System.in);
		int val = -1;
		while (val < 1 || val > 7) {
			System.out.println("(1) Update Balance\n"
							 + "(2) View Balances\n"
							 + "(3) Transfer Funds\n"
							 + "(4) Close Account\n"
							 + "(5) Open Account\n"
							 + "(6) Edit Details\n"
							 + "(7) Logout");
			val = Integer.parseInt(scan.nextLine());
		}
		switch (val) 
		{
		case 1:
			op = Operation.UPDATE_BAL;
			break;
		case 2:
			op = Operation.VIEW_BAL;
			break;
		case 3:
			op = Operation.TRANSFER_FUNDS;
			break;
		case 4:
			op = Operation.CLOSE_ACCT;
			break;
		case 5:
			op = Operation.CREATE_ACCT;
			break;
		case 6:
			op = Operation.EDIT_DETAILS;
			break;
		case 7:
			op = Operation.LOGOUT;
			break;
		}
	}
	
	
	public void run()
	{
		User u = login_or_new();
		while (u != null)
		{
			getAction();
			switch (op) 
			{
			case UPDATE_BAL:
				updateBalance(u);
				break;
			case VIEW_BAL:
				viewBalance(u);
				break;
			case EDIT_DETAILS:
				editDetails(u);
				break;
			case TRANSFER_FUNDS:
				transferFunds(u);
				break;
			case CLOSE_ACCT:
				closeAccount(u);
				break;
			case CREATE_ACCT:
				createAccount(u);
				break;
			case LOGOUT:
				u = logout();
				break;
			default:
				break;
			}
		}
		op = Operation.SHUTDOWN;	
	}
}
