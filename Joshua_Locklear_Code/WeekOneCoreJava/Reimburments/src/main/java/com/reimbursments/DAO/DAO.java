package com.reimbursments.DAO;

import java.util.ArrayList;
import java.util.HashMap;


import com.reimbursments.pojos.Reimburs;
import com.reimbursments.pojos.Status;
import com.reimbursments.pojos.Users;

public interface DAO {
	ArrayList<Users> getUsers();
	void createUser(String fname, String lname, String email, String password);
	void createReimbursement(Users u, double d, String desc);
	ArrayList<Reimburs> getAllReimbursements();
	ArrayList<Reimburs> getReimbursement(Users u);
	void getPendingReimbursements();
	void getResolvedReimbursements();
	void UpdateUser(Users u);
	void getSingleUser(Users u);
	void ApproveOrDeny(int resId, String notes, int r_id, int re_id);

}
