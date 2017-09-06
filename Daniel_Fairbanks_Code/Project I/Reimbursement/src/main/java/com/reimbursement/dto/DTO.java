package com.reimbursement.dto;

import java.util.ArrayList;

import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.User;

public class DTO {
	
	private User user;
	private ArrayList<Reimbursement> requests;
	
	public DTO() {}

	public DTO(User user, ArrayList<Reimbursement> requests) {
		super();
		this.user = user;
		this.requests = requests;
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
	
}
