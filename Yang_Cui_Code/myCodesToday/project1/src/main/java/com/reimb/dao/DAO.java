package com.reimb.dao;

import java.util.ArrayList;

import com.reimb.pojo.ApproveStat;
import com.reimb.pojo.Remibursment;
import com.reimb.pojo.Users;

public interface DAO {
	public Users getUser(int userID);
	public ArrayList<Users> getAllUser();
	public int getUserID(String userName);
	public int addUser(Users user);
	public Remibursment getRemib(int reimbID);
	public ArrayList<Remibursment> getAllRemib();
	public ArrayList<Remibursment> getUserRemib(int userID);
	public ArrayList<Remibursment> getStatRemib(int statID);
	public int submitRemib(Remibursment reimb);
	public int resolveRemib(Remibursment reimb);
	public ApproveStat getStatus(int statID);
}
