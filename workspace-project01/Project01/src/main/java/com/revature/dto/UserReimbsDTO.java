package com.revature.dto;

import java.util.ArrayList;

import com.revature.model.RUser;
import com.revature.model.Reimbursement;

public class UserReimbsDTO {
	
	private RUser user;
	private ArrayList<Reimbursement> reimbs;
	
	public UserReimbsDTO(RUser user, ArrayList<Reimbursement> reimbs) {
		super();
		this.user = user;
		this.reimbs = reimbs;
	}

	public RUser getUser() {
		return user;
	}

	public void setUser(RUser user) {
		this.user = user;
	}

	public ArrayList<Reimbursement> getReimbs() {
		return reimbs;
	}

	public void setReimbs(ArrayList<Reimbursement> reimbs) {
		this.reimbs = reimbs;
	}
	
}
