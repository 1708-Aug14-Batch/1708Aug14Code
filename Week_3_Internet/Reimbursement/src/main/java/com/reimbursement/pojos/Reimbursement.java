package com.reimbursement.pojos;

public class Reimbursement {

	public Reimbursement(int r_id, int sub_id, int res_id, int status_id, String description, String notes,
			int amount) {
		super();
		this.r_id = r_id;
		this.sub_id = sub_id;
		this.res_id = res_id;
		this.status_id = status_id;
		this.description = description;
		this.notes = notes;
		this.amount = amount;
	}
	private int r_id;
	private int sub_id;
	private int res_id;
	private int status_id;
	private String description;
	private String notes;
	private int amount;
	
	
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	public int getRes_id() {
		return res_id;
	}
	public void setRes_id(int res_id) {
		this.res_id = res_id;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Reimbursement [r_id=" + r_id + ", sub_id=" + sub_id + ", res_id=" + res_id + ", status_id=" + status_id
				+ ", description=" + description + ", notes=" + notes + ", amount=" + amount + "]";
	}
	
	
}
