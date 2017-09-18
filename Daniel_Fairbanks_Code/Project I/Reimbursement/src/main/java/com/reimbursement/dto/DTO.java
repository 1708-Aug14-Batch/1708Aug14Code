package com.reimbursement.dto;

import java.util.ArrayList;

import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.User;

public class DTO {
	
	private User user;
	private ArrayList<Reimbursement> requests;
	private ArrayList<User> employees;
	
	public DTO() {}

	
	
	public DTO(User user, ArrayList<Reimbursement> requests, ArrayList<User> employees) {
		super();
		this.user = user;
		this.requests = requests;
		this.employees = employees;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Reimbursement> getRequests() {
		return requests;
	}

	public void setRequests(ArrayList<Reimbursement> requests) {
		this.requests = requests;
	}

	public ArrayList<User> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<User> employees) {
		this.employees = employees;
	}
}
