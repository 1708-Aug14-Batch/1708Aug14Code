package com.reimburse.dto;

import java.util.ArrayList;

import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.User;

public class DTO {
	private User user;
	private ArrayList<Reimbursement> reimburse;
	
	public DTO(){}

	public DTO(User user, ArrayList<Reimbursement> reimburse) {
		super();
		this.user = user;
		this.reimburse = reimburse;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Reimbursement> getReimburse() {
		return reimburse;
	}

	public void setReimburse(ArrayList<Reimbursement> reimburse) {
		this.reimburse = reimburse;
	}
	
	
	

}
