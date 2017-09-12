package com.bank.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class User {

	//user variables
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private BigDecimal balance;
	
	//constructors
	public User() {
	}

	public User(int id, String firstname, String lastname, String username, String password, BigDecimal balance) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}

	public List<String> getInfoAsStringList(){
		List<String> info = new ArrayList<String>();
		info.add(String.valueOf(id));
		info.add(firstname);
		info.add(lastname);
		info.add(username);
		info.add(password);
		info.add(String.valueOf(balance.doubleValue()));
		
		return info;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	
}