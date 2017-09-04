package com.reimbursement.pojos;

public enum ReimbursementStatus {
	PENDING (1),
	APPROVED (2),
	DENIED (3);
	
	private final int id;
	private ReimbursementStatus(int id) {
		this.id=id;
	}
	
	public int getStatus() {
		return id;
	}
	
}