package com.reimburse.dto;

import java.util.ArrayList;

import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.User;

public class ManagerDTO {

	private User user;
	private ArrayList<User> employees;
	private ArrayList<Reimbursement> pending;
	private ArrayList<Reimbursement> resolved;
	
	public ManagerDTO(User user, ArrayList<User> employees, ArrayList<Reimbursement> pending,
			ArrayList<Reimbursement> resolved) {
		this.user = user;
		this.employees = employees;
		this.pending = pending;
		this.resolved = resolved;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<User> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<User> employees) {
		this.employees = employees;
	}

	public ArrayList<Reimbursement> getPending() {
		return pending;
	}

	public void setPending(ArrayList<Reimbursement> pending) {
		this.pending = pending;
	}

	public ArrayList<Reimbursement> getResolved() {
		return resolved;
	}

	public void setResolved(ArrayList<Reimbursement> resolved) {
		this.resolved = resolved;
	}

	@Override
	public String toString() {
		return "ManagerDTO [user=" + user.toString() + ", employees=" + employees.toArray().toString() + ", pending=" + pending + ", resolved="
				+ resolved.toArray().toString() + "]";
	}
	
	
}
