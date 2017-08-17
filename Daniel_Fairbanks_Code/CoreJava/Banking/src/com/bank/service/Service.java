package com.bank.service;

import java.math.BigDecimal;
import java.util.Scanner;

import com.bank.dao.DAO;
import com.bank.dao.DaoTextImpl;
import com.bank.pojos.User;


enum Operation {
	LOGIN, CREATE, LOGOUT,
	UPDATE, VIEW, EDIT,
	INIT, MAIN, RUNNING,
	SHUTDOWN
}

public class Service {
	
	private DaoTextImpl dao = new DaoTextImpl();
	private Operation op = Operation.INIT;
	
	User login_or_new() {
		op = Operation.MAIN;
		
		Scanner scan = new Scanner(System.in);
		String val = "";
		while (val.equalsIgnoreCase("l") == false && val.equalsIgnoreCase("n") == false)
		{
			System.out.println("Login (l) or create a new account (n):");
			val = scan.nextLine();
		}
		scan.close();
		
		User u = null;
		if (val.equals("l"))
			u = login();
		else if (val.equals("n"))
			u = createAcct();
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
		scan.close();
		
		return dao.getUser(email, password);
	}
	
	User createAcct() {
		op = Operation.CREATE;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Firstname:");
		String fn = scan.nextLine();
		System.out.println("Lastname:");
		String ln = scan.nextLine();
		System.out.println("Email:");
		String email = scan.nextLine();
		System.out.println("Password:");
		String password = scan.nextLine();
		System.out.println("Balance:");
		String balance =scan.nextLine();
		int id = dao.getAllUsers().size();
		scan.close();
		
		User tmp = new User();
		tmp.setId(id);
		tmp.setFirstname(fn);
		tmp.setLastname(ln);
		tmp.setEmail(email);
		tmp.setPassword(password);
		tmp.setBalance(new BigDecimal(balance));
		User newUser = dao.addUser(tmp);
		
		return newUser;
	}
	
	void updateBalance(User u) {
		System.out.println("In the update funciton.");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Transfer Amt:");
		BigDecimal amt = new BigDecimal(scan.nextLine());
		u.setBalance(u.getBalance().add(amt));
		scan.close();
		
		dao.editUser(u.getId(), u);
	}
	
	void viewBalance(User u) {
		System.out.println("In the view funciton.");
		
		System.out.println("Balance: " + u.getBalance());
	}
	
	void editAcct(User u) {
		System.out.println("In the edit funciton.");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Firstname:");
		String fn = scan.nextLine();
		System.out.println("Lastname:");
		String ln = scan.nextLine();
		System.out.println("Email:");
		String email = scan.nextLine();
		System.out.println("Password:");
		String password = scan.nextLine();
		scan.close();
		
		u.setFirstname(fn);
		u.setLastname(ln);
		u.setEmail(email);
		u.setPassword(password);
		
		dao.editUser(u.getId(), u);
	}
	
	User logout() {
		System.out.println("In the logout funciton.");
		
		return null;
	}
	
	void getAction() {
		op = Operation.RUNNING;
		
		Scanner scan = new Scanner(System.in);
		String val = "";
		while (val.equalsIgnoreCase("u") == false && val.equalsIgnoreCase("v") == false &&
			   val.equalsIgnoreCase("e") == false && val.equalsIgnoreCase("l") == false)
		{
			System.out.println("Update Bal (u), View Bal (v), Edit User (e), Logout (l):");
			val = scan.nextLine();
		}
		scan.close();
		
		if (val.equals("u"))
			op = Operation.UPDATE;
		else if (val.equals("v"))
			op = Operation.VIEW;
		else if (val.equals("e"))
			op = Operation.EDIT;
		else if (val.equals("l"))
			op = Operation.LOGOUT;
	}
	
	public void run()
	{
		User u = login_or_new();
		while (u != null)
		{
			getAction();
			switch (op) 
			{
			case UPDATE:
				updateBalance(u);
				break;
			case VIEW:
				viewBalance(u);
				break;
			case EDIT:
				editAcct(u);
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
