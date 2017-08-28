package com.bank.pojos;

// A BankUser can have many acounts
// Only has access to their own data

public class BankUser extends Person {

	private final int userId;
	private final String username;
	private String password;
	private final int SSN;		// Matches the SSN of the person who is the user
	
	public BankUser(Person per, int userId, String username, String password) {
		super(per.getSSN(), per.getFirstName(), per.getLastName(), per.getBirthDate());
		this.userId = userId;
		this.username = username;
		this.password = password;
		SSN = per.getSSN();
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public String getUsername() {
		return username;
	}
	public int getSSN() {
		return SSN;
	}
	@Override
	public String toString() {
		return "BankUser [userId=" + userId + ", username=" + username + ", password=" + password + ", SSN=" + SSN
				+ "]";
	}
	
}