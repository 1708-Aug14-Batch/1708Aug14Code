package com.pone.pojos;

public class RStatus {

	int st_id;
	String stName;
	
	public RStatus() {}
	
	public RStatus(int st_id, String stName) {
		super();
		this.st_id = st_id;
		this.stName = stName;
	}

	public int getSt_id() {
		return st_id;
	}

	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	@Override
	public String toString() {
		return "RStatus [st_id=" + st_id + ", stName=" + stName + "]";
	}
	
	
	
}
