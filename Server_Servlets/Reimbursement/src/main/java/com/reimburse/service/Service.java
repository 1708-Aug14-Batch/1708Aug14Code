package com.reimburse.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.reimburse.dao.DaoImpl;
import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.Reimbursement.reimbursementStatus;
import com.reimburse.pojos.Worker;
import org.apache.log4j.Logger;

// TODO this class is where I will checking updating variables to make
// sure they are correct. i.e. valid emails, untaken username, etc
//		ensure correctness on create as well as on update
// TODO add methods to read particular values from database rather than always getting a list of every _____

// FIXME rather than using so many daoImpl.readAllXXX() methods, make more methods in the DaoSqlImpl that are not in the DaoSql interface

public class Service {
	private static Logger log = Logger.getRootLogger();

	DaoImpl daoImpl = new DaoImpl();

	public Worker validateWorker(String username, String password) {
		if (username == null || password == null)
			return null;

		username = username.toLowerCase();

		Worker work = daoImpl.readWorker(username);

		if (work == null)
			return null;

		if (work.getPassword().equals(password))
			return work;
		else return null;
	}

	// FIXME an email does not need to end with .com, could be .org or others
	//		Change to a regular expression using the method .matches()
	public boolean isEmailValid(String email) {

		if (email.contains("@") && email.contains(".com"))
			if (email.lastIndexOf('@') < email.lastIndexOf(".com"))
				return true;

		System.out.println("Email addresses must contain a valid domain such as \"something@something.com\"");
		return false;
	}

	public boolean isEmailAvailable(String email) {

		ArrayList<Worker> workerList = daoImpl.readAllWorkers();

		if (workerList.size() == 0)
			return true;

		for (Worker work : workerList)
			if (work.getEmail() != null && work.getEmail().equalsIgnoreCase(email)) {
				System.out.println("Email unavailable");
				return false;
			}

		return true;
	}

	private boolean isUsernameAvailable(String username) {
		username = username.toLowerCase();

		ArrayList<Worker> userList = daoImpl.readAllWorkers();

		for (Worker work : userList) {
			if (work.getUsername().equalsIgnoreCase(username))
				return false;
		}

		return true;

	}

	// Tries to create a new user
	// Fails if the uername is not unique or if the given worker is already a user
	public Worker tryCreateWorker(String firstName, String lastName, String email, String username,
			String password, boolean isManager) {

		username = username.toLowerCase();

		// Check that username is unique
		if (!isUsernameAvailable(username)) {
			System.out.println("That username is already taken.");
			return null;
		}
		if (!isEmailAvailable(email)) {
			System.out.println("That email is already taken.");
			return null;
		}

		return daoImpl.createWorker(firstName, lastName, email, username, password, isManager, true);
	}

	// Tries to create a new reimbursement
	public Reimbursement tryCreateReimbursement(int submitterId, reimbursementStatus status,
			LocalDateTime submitDate, String description, int ammount) {
		
		if (status == reimbursementStatus.NULL)
			return null;
		if (submitDate == null || ammount < 0)
			return null;
		
		return daoImpl.createReimbursement(submitterId, status, submitDate, description, ammount);
	}

	// Updates a worker with the new worker object.
	// Matches the old worker with the new by workerId
	// All non-final fields of the worker object will be updated
	public boolean updateWorker(int workerId, Worker work) {

		if (work == null)
			return false;

		return daoImpl.updateWorker(workerId, work);

	}

	/*
	public boolean updateReimbursement(int reimbursementId, Reimbursement reimburse) {

		// daoImpl cannot format a null date
		if (reimburse.getSubmitDate() == null) {
			log.warn("Cannot format a null submit date for a reimbursement request");
			return false;
		}
		// A manager cannot submit a reimbursement request
		if (daoImpl.readWorker(reimburse.getSubmitterId()).isManager()) {
			log.warn("A manager cannot submit reimbursements");
			return false;
		}
		// Reimbursement ammount cannot be negative
		if (reimburse.getAmmount() < 0) {
			log.warn("A reimbursement must have a reimbursement ammount >= 0");
			return false;
		}
		
		return daoImpl.updateReimbursement(reimbursementId, reimburse);

	}	
*/
	public Worker getWorker(int workerId) {

		return daoImpl.readWorker(workerId);
	}
	
	// If the resolvedDate is null, gives the current dateTime as the resolvedDate
	public boolean resolveReimbursement(int reimbursementId, int resolverId, reimbursementStatus status, LocalDateTime resolvedDate, String resolveNotes) {
		Worker resolver = daoImpl.readWorker(resolverId);
		
		if (resolver == null) {
			log.warn("That employee is not in the system. ID: " + resolverId);
			return false;
		}
		if (!resolver.isManager() || !resolver.isHired()) {
			log.warn("That employee is not a current manager. Username: " + resolver.getUsername());
			return false;
		}
		if (status == null || status == reimbursementStatus.NULL || status == reimbursementStatus.PENDING) {
			log.warn("Invalid status for resolving a reimbursement. Status: " + status);
			return false;
		}
		
		Reimbursement reimburse = daoImpl.readReimbursement(reimbursementId);
		if (reimburse.getStatus() == reimbursementStatus.APPROVED || reimburse.getStatus() == reimbursementStatus.DENIED) {
			log.warn("That reimbursement is alread closed. ID: " + reimburse.getReimbursementId());
			return false;
		}
		
		// Resolves a null date by giving the current date/time
		if (resolvedDate == null) {
			log.info("Resolved date of reimbursement set to current timestamp. ID: " + reimbursementId);
			resolvedDate = LocalDateTime.now();
		}
		
		log.info("Reimbursement id " + reimbursementId + " set to status: " + status);
		// Set the reimbursement as resolved and save it to the database
		reimburse.setResolverId(resolverId);
		reimburse.setResolvedDate(resolvedDate);
		reimburse.setResolveNotes(resolveNotes);
		daoImpl.updateReimbursement(reimbursementId, reimburse);
		
		return true;
	}

	public ArrayList<Reimbursement> getReimbursements() {

		return daoImpl.readAllReimbursements();
	}

	public boolean isAWorker(String username) {
		Worker work = daoImpl.readWorker(username);

		if (work == null)
			return false;
		else return true;
	}

}
