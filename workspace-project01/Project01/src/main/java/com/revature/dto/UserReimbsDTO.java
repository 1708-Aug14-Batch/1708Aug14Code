package com.revature.dto;

import java.util.ArrayList;

import com.revature.model.RUser;
import com.revature.model.Reimbursement;

public class UserReimbsDTO {
	
	private RUser user;
	private ArrayList<Reimbursement> reimbs;
	
	public UserReimbsDTO(RUser user, ArrayList<Reimbursement> reimbs) {
		this.errorCheckUser(user);
		this.errorCheckReimbs(reimbs);
		this.user = user;
		this.reimbs = reimbs;
	}
	
	private void errorCheckUser(RUser user) {
		if (user == null) {
			throw new IllegalArgumentException("User cannot be null");
		}
	}
	
	private void errorCheckReimbs(ArrayList<Reimbursement> reimbs) {
		if (reimbs == null) {
			throw new IllegalArgumentException("Reimbursements collection cannot be null");
		}
	}

	public RUser getUser() {
		return user;
	}

	public void setUser(RUser user) {
		this.errorCheckUser(user);
		this.user = user;
	}

	public ArrayList<Reimbursement> getReimbs() {
		return reimbs;
	}

	public void setReimbs(ArrayList<Reimbursement> reimbs) {
		this.errorCheckReimbs(reimbs);
		this.reimbs = reimbs;
	}
	
}
