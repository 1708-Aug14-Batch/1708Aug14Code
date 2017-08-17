package com.bank.pojos;

import java.math.BigDecimal;

public class Account {
	
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String pwd;
	private BigDecimal balance;
	
	public Account() {};
	
//	public Account(int id, String fname, String lname, String email, String pwd) {
//		super();
//		this.id = id;
//		this.fname = fname;
//		this.lname = lname;
//		this.email = email;
//		this.pwd = pwd;
//	}
	
	public Account(int id, String fname, String lname, String email, String pwd, BigDecimal balance) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pwd = pwd;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", pwd=" + pwd
				+ ", balance=" + balance + "]";
	}
	
	
	
}
