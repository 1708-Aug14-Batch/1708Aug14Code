package com.bank.service;

import java.util.Scanner;

import com.bank.dao.DAO;
import com.bank.dao.DaoTextImpl;

public class Service {
//login functionality
//what do you want to do functionality
// 
	int id;
	DAO dao = new DaoTextImpl();

	static void createAcct() {
		
	}
	
	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("please enter your first name");
		String fn = scan.nextLine().trim();
		
		System.out.println("please enter your last name");
		String ln = scan.nextLine().trim();
		
		id = dao.getUserID(fn, ln);
		
		System.out.println("value of id: " + id);   // debugging

	}
	
	public static void logout() {
		
	}

	public static void withdrawFunds() {
		
	}
	
	public static void depositFunds() {
		
	}
	
	public static void viewBalance() {
		
	}
	
	public static void editAcctInfo() {
		
	}
}