package com.revature.dto;

public class EditRequestDTO {
	
	private int rID;
	private int status;
	private String resolutionNotes;
	
	public EditRequestDTO() {}
	
	public EditRequestDTO(int rID, int status, String resolutionNotes) {
		this.errorCheckRID(rID);
		this.errorCheckStatus(status);
		this.errorCheckResolutionNotes(resolutionNotes);
		this.rID = rID;
		this.status = status;
		this.resolutionNotes = resolutionNotes;
	}
	
	private void errorCheckRID(int rID) {
		if (rID < 1) {
			throw new IllegalArgumentException("Reimbursement ID cannot be less than 1");
		}
	}
	
	private void errorCheckStatus(int status) {
		if (status < 1 || status > 3) {
			throw new IllegalArgumentException("Status must be 1, 2, or 3");
		}
	}
	
	private void errorCheckResolutionNotes(String resolutionNotes) {
		if (resolutionNotes == null) {
			throw new IllegalArgumentException("Resolution Notes cannot be null");
		}
	}

	public int getrID() {
		return rID;
	}

	public void setrID(int rID) {
		this.errorCheckRID(rID);
		this.rID = rID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.errorCheckStatus(status);
		this.status = status;
	}

	public String getResolutionNotes() {
		return resolutionNotes;
	}

	public void setResolutionNotes(String resolutionNotes) {
		this.errorCheckResolutionNotes(resolutionNotes);
		this.resolutionNotes = resolutionNotes;
	}
	
	

}
