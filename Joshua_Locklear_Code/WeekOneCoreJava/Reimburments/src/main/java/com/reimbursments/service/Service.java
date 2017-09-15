package com.reimbursments.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.reimbursments.DAO.DAO;
import com.reimbursments.DAO.DAOImpl;
import com.reimbursments.pojos.Reimburs;
import com.reimbursments.pojos.Users;

public class Service {
	static DAO dao = new DAOImpl();
	
	public void submitReimbursement(Users u, Reimburs r){ 
		ArrayList<Users> list = dao.getUsers();
		
		for(Users t: list){
			if(t.getEmail().equals(u.getEmail())) {
				System.out.println("Before ID: " + t.getUserid());
				u.setUserid(t.getUserid());
			}
		}
		System.out.println("After ID: " + u.getUserid());
		dao.createReimbursement(u, r.getAmount(), r.getDescription());
		System.out.println("We got here after the DAO");
		
	}
	public ArrayList<Reimburs> getAllReimbursements(){
		ArrayList<Reimburs> list = dao.getAllReimbursements();
		return list;
	}
	public boolean checkEmail(String email) {
		ArrayList<Users> list = dao.getUsers();
		for(Users u: list) {
			if(u.getEmail().equals(email)) {
				return true;
			}
		}
		return false;


	}

	public boolean checkPassword(String email, String password) {
		ArrayList<Users> list = dao.getUsers();
		for(Users u: list) {
			if(u.getEmail().equals(email)) {
				if(u.getPassword().equals(password)) {
					
					return true;
				}
					
			}
		}
		return false;
	}
	
	//This is used to establish the User to pass through the session.
	//It uses the same checker as the username/password to set up the user.
	//When ran through a main method it properly creates the user.
	
	//The example used here is username: ctest123@gmail.com and password: ctest123
	public Users loginUser(String email) {
		ArrayList<Users> list = dao.getUsers();
		Users user = new Users();
		for(Users u: list) {
			if(u.getEmail().equals(email)) {
				user.setUserid(u.getUserid());
				user.setFirstName(u.getFirstName());
				user.setLastName(u.getLastName());
				user.setEmail(u.getEmail());
				user.setPassword(u.getPassword());
				user.setIsManager(u.getIsManager());
				System.out.println(user.toString());
				return user;
			}
		}
		return null;
	}
	public ArrayList<Reimburs> getUserReimbursements(Users u) {
		ArrayList<Reimburs> list = dao.getAllReimbursements();
		ArrayList<Reimburs> test = new ArrayList<Reimburs>();
		for(Reimburs r: list) {
			if(r.getSub_id() == u.getUserid()) {
				test.add(r);
			}
		}
		return test;
		
	}
	public void updateUser(Users u) {
		System.out.println(u.toString());
		dao.UpdateUser(u);
	}
	
	public ArrayList<Users> getAllUsers(){
		ArrayList<Users> list = dao.getUsers();
		System.out.println("User list: " + list.toString());
		return list;
	}
	
	public void ApporDeny(int resId, String notes, int r_id, int re_id) {
		dao.ApproveOrDeny(resId,notes,r_id,re_id);
	}
	
	public void createUser(String fname, String lname, String email, String password) {
		dao.createUser(fname, lname, email, password);
	}

}
