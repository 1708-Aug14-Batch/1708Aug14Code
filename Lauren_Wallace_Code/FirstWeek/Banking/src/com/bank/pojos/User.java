package com.bank.pojos;

public class User {
	
	//variables that handle numbers
	private int id;
	private double balance;
	
	//variables that handle Strings
	private String firstName;
	private String lastName;
	private String userName; //or email; must be unique & not null
	private String password;
	
	//variables that handle user status aka boolean values
	private boolean status = false;
	
	//default constructor for User
	public User() {
		this.id = 0;
		this.balance = 0.00;
		this.firstName = "";
		this.lastName = "";
		this.userName = "";
		this.password = "";
		this.status = false;
	}
	
	//overloads the default constructor by changing the method signature & implementation
	//to be used when the user creates their account
	public User(int id, String firstName, String lastName, String userName, String password) {
		this.id = id;
		this.balance = 0.00;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.status = false;
	}
	
	//overloads the default constructor by changing the method signature & implementation
	//for the future if the bank wants to allow a user to specify a beginning balance to 
	//put into their account
	//Note: not currently implemented
	public User(int id, double balance, String firstName, String lastName, String userName, String password) {
		this.id = id;
		this.balance = balance;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.status = false;
	}

	//getters & setters for encapsulation
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
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

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
