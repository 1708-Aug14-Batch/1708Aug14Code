package com.reimburse.dto;

import java.util.ArrayList;

import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.Worker;

/*
 * This is a single object needed to transfer objects necessary for
 * a single user logged in
 */

public class DTO {

	private Worker user;
	private ArrayList<Reimbursement> reimbursements;

	public DTO(Worker user, ArrayList<Reimbursement> reimbursements) {
		super();
		this.user = user;
		this.reimbursements = reimbursements;
	}

	public Worker getUser() {
		return user;
	}

	public void setUser(Worker user) {
		this.user = user;
	}

	public ArrayList<Reimbursement> getReimbursements() {
		return reimbursements;
	}

	public void setReimbursements(ArrayList<Reimbursement> reimbursements) {
		this.reimbursements = reimbursements;
	}

	@Override
	public String toString() {
		return "DTO [user=" + user + ", reimbursements=" + reimbursements + "]";
	}

}
