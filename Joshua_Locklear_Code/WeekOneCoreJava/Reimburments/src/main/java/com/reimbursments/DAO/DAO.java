package com.reimbursments.DAO;

import java.util.ArrayList;
import java.util.HashMap;


import com.reimbursments.pojos.Reimburs;
import com.reimbursments.pojos.Status;
import com.reimbursments.pojos.Users;

public interface DAO {
	void Resolve(int resId, String notes, int r_id, int re_id);
	void createUser(String fname, String lname, String email, String password);
	void createReim(Users u, double d, String desc);
	ArrayList<Reimburs> getAllReim();
	void getPending();
	ArrayList<Users> getUsers();
	void getResolved();
	void UpdateUser(Users u);
	void getSingleUser(Users u);
	ArrayList<Reimburs> getAccounts(Users u);

}
