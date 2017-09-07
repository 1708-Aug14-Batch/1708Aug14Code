package com.pone.dto;

import java.util.ArrayList;

import com.pone.pojos.AUser;
import com.pone.pojos.Reimbursement;

public class DTO {

	private AUser aUser;
	private ArrayList<Reimbursement> reimbursements;
	
	public DTO() {}

	public DTO(AUser aUser, ArrayList<Reimbursement> reimbursements) {
		super();
		this.aUser = aUser;
		this.reimbursements = reimbursements;
	}

	public AUser getAUser() {
		return aUser;
	}

	public void setAUser(AUser aUser) {
		this.aUser = aUser;
	}

	public ArrayList<Reimbursement> getReimbursements() {
		return reimbursements;
	}

	public void setReimbursements(ArrayList<Reimbursement> reimbursements) {
		this.reimbursements = reimbursements;
	}
	
	
	
	
}
