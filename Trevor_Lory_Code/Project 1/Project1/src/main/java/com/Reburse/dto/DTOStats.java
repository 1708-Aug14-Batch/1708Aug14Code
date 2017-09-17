package com.Reburse.dto;

public class DTOStats {

	private int pending;
	private int accepted;
	private int denied;
	
	public DTOStats() {}
	
	public DTOStats(int pending, int accepted, int denied) {
		super();
		this.pending = pending;
		this.accepted = accepted;
		this.denied = denied;
	}

	public int getPending() {
		return pending;
	}

	public void setPending(int pending) {
		this.pending = pending;
	}

	public int getAccepted() {
		return accepted;
	}

	public void setAccepted(int accepted) {
		this.accepted = accepted;
	}

	public int getDenied() {
		return denied;
	}

	public void setDenied(int denied) {
		this.denied = denied;
	}
	
}
