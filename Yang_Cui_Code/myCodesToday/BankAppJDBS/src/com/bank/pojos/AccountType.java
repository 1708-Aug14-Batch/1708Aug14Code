package com.bank.pojos;

public class AccountType {
	private int id;
	private String name;
	
	public AccountType(){
		
	}
	
	public AccountType(int id, String name){
		this.id=id;
		this.name=name;
	}

	public int getID(){
		return id;
	}
	
	public String getName(){
		return name;
	}
}
