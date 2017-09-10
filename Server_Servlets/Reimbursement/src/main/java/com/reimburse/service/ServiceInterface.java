package com.reimburse.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.Reimbursement.reimbursementStatus;
import com.reimburse.pojos.Worker;

public interface ServiceInterface {

	public Worker validateWorker(String username, String password);
	
	public Worker tryCreateWorker(int managerId, String firstName, String lastName,
			String email, String username, String password,	boolean isManager);

	public Reimbursement tryCreateReimbursement(int employeeId, String description, BigDecimal ammount);

	public Worker getWorker(int workerId);

	public boolean isAWorker(String username);

	public boolean isAManager(String username);

	public boolean isManager(int id);

	public boolean updateWorker(int id, String firstName, String lastName, String email, String username, String password);

	public boolean resolveReimbursement(int managerId, int reimbursementId, reimbursementStatus status, String resolveNotes);

	public ArrayList<Reimbursement> getPendingReimbursements();

	public ArrayList<Reimbursement> getResolvedReimbursements();

	public ArrayList<Reimbursement> getPendingReimbursements(int employeeId);

	public ArrayList<Reimbursement> getResolvedReimbursements(int employeeId);

	public ArrayList<Reimbursement> getEmployeesReimbursements(int employeeId);

	public ArrayList<Worker> getAllEmployees(int managerId);
}
