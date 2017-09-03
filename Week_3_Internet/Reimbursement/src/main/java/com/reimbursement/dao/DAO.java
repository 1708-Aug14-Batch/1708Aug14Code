package com.reimbursement.dao;

import java.util.ArrayList;

import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.User;

public interface DAO {
	
	ArrayList<User> getUsers();
	void createUser();
	void createReimbursement(User u, int amt, String desc);
	ArrayList<Reimbursement> getAllReimbursements();
	void getReimbursement(int id);
	void getPendingReimbursements();
	void getResolvedReimbursements();
	void UpdateUser(User u);
	void getSingleUser(User u);
	void ApproveOrDeny(int stat_id, int id, String notes);
}
