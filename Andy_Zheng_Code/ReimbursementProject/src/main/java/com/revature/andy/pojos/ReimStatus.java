package com.revature.andy.pojos;

public class ReimStatus {
	
	private int statusID;
	private String statusName;
	
	public ReimStatus() {}

	public ReimStatus(int statusID, String statusName) {
		super();
		this.statusID = statusID;
		this.statusName = statusName;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	};
	
	
	
}
