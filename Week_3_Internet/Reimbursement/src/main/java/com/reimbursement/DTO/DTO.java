package com.reimbursement.DTO;

import java.util.ArrayList;

import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.User;

public class DTO {

	private User user;
	private ArrayList<Reimbursement> accounts;
	private ArrayList<User> userList;
	public DTO() {}
	
	public DTO(User user, ArrayList<Reimbursement> accounts, ArrayList<User> userList) {
		super();
		this.user = user;
		this.accounts = accounts;
		this.userList = userList;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public DTO(ArrayList<Reimbursement> accounts, ArrayList<User> userList) {
		super();
		this.accounts = accounts;
		this.userList = userList;
	}



	public DTO(User user, ArrayList<Reimbursement> accounts) {
		super();
		this.user = user;
		this.accounts = accounts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Reimbursement> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Reimbursement> accounts) {
		this.accounts = accounts;
	}
	
	
}
