package com.revature.dto;

import java.util.ArrayList;

import com.revature.model.RUser;
import com.revature.model.Reimbursement;

public class UserPendingReimbsDTO {
	
	private RUser user;
	private ArrayList<Reimbursement> pendingReimbs;
	
	public UserPendingReimbsDTO(RUser user, ArrayList<Reimbursement> pendingReimbs) {
		super();
		this.user = user;
		this.pendingReimbs = pendingReimbs;
	}

	public RUser getUser() {
		return user;
	}

	public void setUser(RUser user) {
		this.user = user;
	}

	public ArrayList<Reimbursement> getPendingReimbs() {
		return pendingReimbs;
	}

	public void setPendingReimbs(ArrayList<Reimbursement> pendingReimbs) {
		this.pendingReimbs = pendingReimbs;
	}
	
}
