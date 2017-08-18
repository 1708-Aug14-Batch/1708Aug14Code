package com.bank.pojos;

import java.math.BigDecimal;

public class User {

	private String userID;
	private String firstName;
	private String lastName;
	private String email;
	private String passWord;
	private Integer balance; //Used for monetary reasons
	
	public User() {};
	
	public User(String userID, String firstName, String lastName, String email, String passWord, Integer balance) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passWord = passWord;
		this.balance = balance;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public Integer getBalance() {
		return balance;
	}


	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
	// add constructors, getters, setters
	
}
