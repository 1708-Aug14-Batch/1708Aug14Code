package com.revature.dto;

import java.util.ArrayList;

import com.revature.pojo.Account;
import com.revature.pojo.User;

public class DTO {
	private User user;
	private ArrayList<Account> accounts;
	
	public DTO(){}
	
	public DTO(User user, ArrayList<Account> accounts){
		super();
		this.user=user;
		this.accounts=accounts;
	}
	
	public User getUser(){
		return user;
	}
	
	public void setUser(User user){
		this.user=user;
	}
	
	public ArrayList<Account> getAccount(){
		return accounts;
	}
	
	public void setAccount(ArrayList<Account> accounts){
		this.accounts=accounts;
	}
}
