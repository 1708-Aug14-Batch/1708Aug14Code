package com.Reburse.pojos;

import java.sql.Timestamp;

public class Reimbursement {

	private int R_ID; //Reimbursement ID
	private String Sub; //Submitter Name
	private String Res; //Resolver Name
	private String SubDate; //Submit Date
	private String ResDate; //Resolve Date
	private String Status; //If asking for string name this should "print" out via switch statement
	private String Desc; //Description
	private String ResNote; //Resolve Note
	private double Amount; //Amount
	
	public Reimbursement(String sub, String subDate, int statusID, String desc, double amount) {
		super();
		Sub = sub;
		SubDate = subDate;
		Status = getStatusName(statusID);
		Desc = desc;
		Amount = amount;
	}

	public Reimbursement(int r_ID, String sub, String res, String subDate, String resDate, int statusID, String desc,
			String resNote, double amount) {
		super();
		R_ID = r_ID;
		Sub = sub;
		Res = res;
		SubDate = subDate;
		ResDate = resDate;
		Status = getStatusName(statusID);
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

	public String getSub() {
		return Sub;
	}

	public void setSub(String sub) {
		Sub = sub;
	}

	public String getRes() {
		return Res;
	}

	public void setRes_ID(String res) {
		Res = res;
	}

	public String getSubDate() {
		return SubDate;
	}

	public void setSubDate(String subDate) {
		SubDate = subDate;
	}

	public String getResDate() {
		return ResDate;
	}

	public void setResDate(String resDate) {
		ResDate = resDate;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatusID(String status) {
		Status = status;
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
		return "Reimbursement [R_ID=" + R_ID + ", Sub_ID=" + Sub + ", Res_ID=" + Res + ", SubDate=" + SubDate
				+ ", ResDate=" + ResDate + ", StatusID=" + Status + ", Desc=" + Desc + ", ResNote=" + ResNote
				+ ", Amount=" + Amount + "]";
	}
	
	public String getStatusName(int StatusID) {
		switch(StatusID) {
		case 0:
			return "<b style='color: blue'>Pending<b>";
		case 1:
			return "<b style='color: green'>Approved<b>";
		case 2:
			return "<b style='color: red'>Denied<b>";
		}
		return "Improper StatusID";
	}
	
}
