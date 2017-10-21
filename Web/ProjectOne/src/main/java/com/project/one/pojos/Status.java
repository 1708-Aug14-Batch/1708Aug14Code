package com.project.one.pojos;

public class Status {
	private int ID;
	private String desc;

	public Status(int id){
		this.ID = id;
		switch(id) {
		case 0: this.desc = "Pending";
		break;
		case 1: this.desc = "Approved";
		break;
		case 2: this.desc = "Denied";
		break;
		}
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}


