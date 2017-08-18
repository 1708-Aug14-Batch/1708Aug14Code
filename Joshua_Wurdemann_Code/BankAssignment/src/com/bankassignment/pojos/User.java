package com.bankassignment.pojos;


/** Creates User object the new bank customer
 * 
 * @author Josh Wurdemann
 * @version 8/17/2017
 */
public class User {
	private String accountId;
	private String firstname;
	private String lastname;
	private String email; //can be username
	private String password;
	private Double balance;// Use Big decimal for montary reasons. "Can change to double"


	/**
	 * Empty Constructor.
	 */
	public User() {

	}
	/** 
	 * Constructs a user object.
	 * @param id  the Id.
	 * @param firstname the first name.
	 * @param lastname the last name.
	 * @param email    the email.
	 * @param password the password.
	 * @param balance  the balance.
	 */

	public User(String accountId, String firstname, String lastname, String email, String password, Double balance) {
		super();
		this.accountId = accountId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "User [id=" + accountId + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", balance=" + balance + "]";
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
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
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}



}
