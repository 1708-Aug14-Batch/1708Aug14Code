package com.reimburse.dto;

import java.util.ArrayList;

import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.ReimbursementDTO;
import com.reimburse.pojos.Worker;

/*
 * This is a single object needed to transfer objects necessary for
 * a single user logged in
 */

public class DTO {

	private Worker user;
	private ArrayList<ReimbursementDTO> reimbursements;

	public DTO(Worker user, ArrayList<ReimbursementDTO> reimburseList) {
		super();
		this.user = user;
		this.reimbursements = reimburseList;
	}

	public Worker getUser() {
		return user;
	}

	public void setUser(Worker user) {
		this.user = user;
	}

	public ArrayList<ReimbursementDTO> getReimbursements() {
		return reimbursements;
	}

	public void setReimbursements(ArrayList<ReimbursementDTO> reimbursements) {
		this.reimbursements = reimbursements;
	}

	@Override
	public String toString() {
		return "DTO [user=" + user + ", reimbursements=" + reimbursements + "]";
	}

}
