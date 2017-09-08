package com.bank.pojos;

import java.math.BigDecimal;

public class User {
<<<<<<< HEAD
=======
	
>>>>>>> a3d401426b647d7925ad2c6a5500154ce783b45c
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private double balance;
	
<<<<<<< HEAD
	public User() {}
	
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
	
	
=======
	// add constructors, getters, setters
	
	public User(double balance){
		this.balance = 0.00;
	}

>>>>>>> a3d401426b647d7925ad2c6a5500154ce783b45c
}
