package com.reimburse.dto;

import java.util.ArrayList;

import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.User;

public class DTO {

	private User user;
	private ArrayList<Reimbursement> reimbursements;
	
	public DTO(User user, ArrayList<Reimbursement> reimbursements) {
		this.user = user;
		this.reimbursements = reimbursements;
	}

	@Override
	public String toString() {
		return "DTO [user=" + user + ", reimbursements=" + reimbursements + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Reimbursement> getReimbursements() {
		return reimbursements;
	}

	public void setReimbursements(ArrayList<Reimbursement> reimbursements) {
		this.reimbursements = reimbursements;
	}
}
