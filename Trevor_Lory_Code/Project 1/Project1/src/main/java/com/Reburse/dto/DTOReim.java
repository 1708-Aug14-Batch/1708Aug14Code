package com.Reburse.dto;

import java.util.ArrayList;

import com.Reburse.pojos.Reimbursement;

public class DTOReim {
	ArrayList<Reimbursement> Reims = new ArrayList<Reimbursement>();

	public DTOReim(ArrayList<Reimbursement> reims) {
		super();
		Reims = reims;
	}

	public ArrayList<Reimbursement> getReims() {
		return Reims;
	}

	public void setReims(ArrayList<Reimbursement> reims) {
		Reims = reims;
	}
	
}
