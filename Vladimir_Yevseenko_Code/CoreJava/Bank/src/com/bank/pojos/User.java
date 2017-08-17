package com.bank.pojos;

import java.math.BigDecimal;

public class User {
	
	private static int nextID;
	private final int id;
	private String first, last, email, password;
	private BigDecimal balance;
	
	public User() {
		this.id = nextID++;
		balance = BigDecimal.ZERO;
	}
	
	public User(int id) {
		this.id = id;
		if (id >= nextID)
			nextID = id + 1;
	}
	
	public String getFirst() {
		return first;
	}
	
	public void setFirst(String first) {
		this.first = first;
	}
	
	public String getLast() {
		return last;
	}
	
	public void setLast(String last) {
		this.last = last;
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
	
	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	
	public void deposit(BigDecimal b) {
		balance = balance.add(b);
	}
	
	public boolean withdraw(BigDecimal b) {
		if (balance.compareTo(b) < 0)
			return false;
			
		balance = balance.subtract(b);
		return true;
	}

	public String toStoredForm() {
		return id+":"+first+":"+last+":"+email+":"+password+":"+balance;
	}

	public static User fromStoredForm(String line) {
		String[] fields = line.split(":");
		User u = new User(Integer.parseInt(fields[0]));
		u.first = fields[1];
		u.last = fields[2];
		u.email = fields[3];
		u.password = fields[4];
		u.balance = new BigDecimal(fields[5]);
		return u;
	}
}
