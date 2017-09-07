package com.ers.dto;

import java.util.ArrayList;

import com.ers.pojos.Employee;
import com.ers.pojos.Reimbursement;

public class DTO {
	
	public Employee emp;
	public ArrayList<Reimbursement> reimbs;
	
	public DTO() {}

	public DTO(Employee emp, ArrayList<Reimbursement> reimbs) {
		super();
		this.emp = emp;
		this.reimbs = reimbs;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public ArrayList<Reimbursement> getReimbs() {
		return reimbs;
	}

	public void setReimbs(ArrayList<Reimbursement> reimbs) {
		this.reimbs = reimbs;
	}

	@Override
	public String toString() {
		return "DTO [emp=" + emp + ", reimbs=" + reimbs + "]";
	}
	
	

}
