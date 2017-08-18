package com.bank.pojos;

import java.math.BigDecimal;
import java.util.Random;

public class User {
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private double balance;
	// No args constructor
	public User(){}
	
	public User(int id, String firstname, String lastname, String email, String password, double balance) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.balance = balance;
	}

	public int getId() {
		Random rand = new Random();
		 int id = rand.nextInt(15) + 1;
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
