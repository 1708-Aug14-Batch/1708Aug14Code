package com.revature.andy.dto;

import java.util.HashSet;

import com.revature.andy.pojos.Reimbursement;
import com.revature.andy.pojos.User;

public class DTO {

	private User user;
	private HashSet<Reimbursement> reim;
	
	public DTO() {};
	
	public DTO(User user, HashSet<Reimbursement> reim) {
		super();
		this.user = user;
		this.reim = reim;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public HashSet<Reimbursement> getReim() {
		return reim;
	}

	public void setReim(HashSet<Reimbursement> reim) {
		this.reim = reim;
	}
	
}
