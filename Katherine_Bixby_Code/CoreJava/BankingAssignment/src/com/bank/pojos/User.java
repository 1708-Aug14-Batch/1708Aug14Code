package com.bank.pojos;

import java.math.BigDecimal;

public class User {
	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private int userID;
	private BigDecimal balance;
	
	public User(int userID, String firstName, String lastName, String userName, String password, BigDecimal balance) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.userID = userID;
		this.balance = balance;
	}
	
	public User() {}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
//	public void printUser() {
//		System.out.println("UID: "+this.getUserID());
//		System.out.println("First: "+this.firstName);
//		System.out.println("Last: "+this.lastName);
//		System.out.println("Username: "+this.userName);
//		System.out.println("Pass: "+this.password);
//		System.out.println("Balance: "+this.balance);
//	}
	

}
