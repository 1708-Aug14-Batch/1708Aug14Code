package com.Reburse.pojos;

import java.sql.Timestamp;

public class Reimbursement {

	private int R_ID;
	private int Sub_ID;
	private int Res_ID;
	private Timestamp SubDate;
	private Timestamp ResDate;
	private int StatusID = 0; //If asking for string name this should "print" out via switch statement
	private String Desc;
	private String ResNote;
	private double Amount;
	
	public Reimbursement(int sub_ID, Timestamp subDate, int statusID, String desc, double amount) {
		super();
		Sub_ID = sub_ID;
		SubDate = subDate;
		StatusID = statusID;
		Desc = desc;
		Amount = amount;
	}

	public Reimbursement(int r_ID, int sub_ID, int res_ID, Timestamp subDate, Timestamp resDate, int statusID, String desc,
			String resNote, double amount) {
		super();
		R_ID = r_ID;
		Sub_ID = sub_ID;
		Res_ID = res_ID;
		SubDate = subDate;
		ResDate = resDate;
		StatusID = statusID;
		Desc = desc;
		ResNote = resNote;
		Amount = amount;
	}

	public int getR_ID() {
		return R_ID;
	}

	public void setR_ID(int r_ID) {
		R_ID = r_ID;
	}

	public int getSub_ID() {
		return Sub_ID;
	}

	public void setSub_ID(int sub_ID) {
		Sub_ID = sub_ID;
	}

	public int getRes_ID() {
		return Res_ID;
	}

	public void setRes_ID(int res_ID) {
		Res_ID = res_ID;
	}

	public Timestamp getSubDate() {
		return SubDate;
	}

	public void setSubDate(Timestamp subDate) {
		SubDate = subDate;
	}

	public Timestamp getResDate() {
		return ResDate;
	}

	public void setResDate(Timestamp resDate) {
		ResDate = resDate;
	}

	public int getStatusID() {
		return StatusID;
	}

	public void setStatusID(int statusID) {
		StatusID = statusID;
	}

	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}

	public String getResNote() {
		return ResNote;
	}

	public void setResNote(String resNote) {
		ResNote = resNote;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	@Override
	public String toString() {
		return "Reimbursement [R_ID=" + R_ID + ", Sub_ID=" + Sub_ID + ", Res_ID=" + Res_ID + ", SubDate=" + SubDate.toString()
				+ ", ResDate=" + ResDate.toString() + ", StatusID=" + StatusID + ", Desc=" + Desc + ", ResNote=" + ResNote
				+ ", Amount=" + Amount + "]";
	}
	
	public String getStatusName() {
		switch(StatusID) {
		case 0:
			return "Pending";
		case 1:
			return "Approved";
		case 2:
			return "Denied";
		}
		return "Improper StatusID";
	}
	
}
