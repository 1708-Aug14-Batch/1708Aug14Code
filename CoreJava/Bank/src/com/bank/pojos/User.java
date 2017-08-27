package com.bank.pojos;

import java.math.BigDecimal;

public class User {
	
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private double balance;
	
	// add constructors, getters, setters
	
	public User(double balance){
		this.balance = 0.00;
	}

}
