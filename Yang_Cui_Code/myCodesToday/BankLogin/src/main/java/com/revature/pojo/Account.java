package com.revature.pojo;

public class Account {
	private int id;
	private double balance;
	private User user;
	private AccountType type;
	
	public Account(int id, double balance, User user, AccountType type){
		this.id=id;
		this.balance=balance;
		this.user=user;
		this.type=type;
	}
	
	public Account(){
		
	}
	
	public int getID(){
		return id;
	}
	
	public void setID(int id){
		this.id=id;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public void setBalance(double balance){
		this.balance=balance;
	}
	
	public User getUser(){
		return user;
	}
	
	public AccountType getType(){
		return type;
	}
}
