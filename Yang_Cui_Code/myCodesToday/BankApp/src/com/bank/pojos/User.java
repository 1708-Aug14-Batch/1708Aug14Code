package com.bank.pojos;

import java.math.BigDecimal;

public class User {
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private int balance;
	
	// user file looks like this:
	// id:firatname:lastname:email:password:balance\n
	public User(String id, String firstname, String lastname, String email, String password, String balance){
		this.id=Integer.parseInt(id);
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
		this.password=password;
		this.balance=Integer.parseInt(balance);
	}
	
	public User(){
		
	}
	
	public int getID(){
		return id;
	}
	
	public String getFirstname(){
		return firstname;
	}
	public void setFirstname(String firstname){
		this.firstname=firstname;
	}
	
	public String getLastname(){
		return lastname;
	}
	public void setLastname(String lastname){
		this.lastname=lastname;
	}
	
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email=email;
	}
	
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	
	public int getBalance(){
		return balance;
	}
	public void setBalance(int balance){
		this.balance=balance;
	}
}
