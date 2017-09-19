package com.reimbursments.dto;

import java.util.ArrayList;

import com.reimbursments.pojos.Reimburs;
import com.reimbursments.pojos.Users;


public class DTO {
	
	private Users user;
	private ArrayList<Reimburs> accounts;
	private ArrayList<Users> EmployeeList;
	public DTO() {
		super();
	}
	
	public DTO(ArrayList<Reimburs> accounts, ArrayList<Users> userList) {
		super();
		this.accounts = accounts;
		this.EmployeeList = userList;
	}
	
	public DTO(Users user, ArrayList<Reimburs> accounts, ArrayList<Users> EmployeeList) {
		super();
		this.user = user;
		this.accounts = accounts;
		this.EmployeeList = EmployeeList;
	}

	public ArrayList<Users> getUserList() {
		return EmployeeList;
	}
	
	public ArrayList<Reimburs> getAccounts() {
		return accounts;
	}

	public void setUserList(ArrayList<Users> EmployeeList) {
		this.EmployeeList = EmployeeList;
	}


	public void setAccounts(ArrayList<Reimburs> accounts) {
		this.accounts = accounts;
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


	

}
