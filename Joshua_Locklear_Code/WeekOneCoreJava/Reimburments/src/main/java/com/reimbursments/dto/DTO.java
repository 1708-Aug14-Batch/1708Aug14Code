package com.reimbursments.dto;

import java.util.ArrayList;

import com.reimbursments.pojos.Reimburs;
import com.reimbursments.pojos.Users;


public class DTO {
	
	private Users user;
	private ArrayList<Reimburs> accounts;
	private ArrayList<Users> userList;
	public DTO() {}
	
	public DTO(Users user, ArrayList<Reimburs> accounts, ArrayList<Users> userList) {
		super();
		this.user = user;
		this.accounts = accounts;
		this.userList = userList;
	}

	public ArrayList<Users> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<Users> userList) {
		this.userList = userList;
	}

	public DTO(ArrayList<Reimburs> accounts, ArrayList<Users> userList) {
		super();
		this.accounts = accounts;
		this.userList = userList;
	}



	public DTO(Users user, ArrayList<Reimburs> accounts) {
		super();
		this.user = user;
		this.accounts = accounts;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public ArrayList<Reimburs> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Reimburs> accounts) {
		this.accounts = accounts;
	}
	

}
