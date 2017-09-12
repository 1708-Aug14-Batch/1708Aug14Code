package com.reimbursement.dao;

import java.util.ArrayList;

import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.User;

public interface DAO {
	
	ArrayList<User> getUsers();
	void createUser();
	void createReimbursement(User u, int amt, String desc);
	ArrayList<Reimbursement> getAllReimbursements();
	ArrayList<Reimbursement> getReimbursement(User u);
	void getPendingReimbursements();
	void getResolvedReimbursements();
	void UpdateUser(User u);
	void getSingleUser(User u);
	void ApproveOrDeny(int resId, String notes, int r_id, int re_id);
}
