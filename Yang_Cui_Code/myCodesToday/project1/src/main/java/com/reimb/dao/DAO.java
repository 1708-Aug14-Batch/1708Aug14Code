package com.reimb.dao;

import com.reimb.pojo.ApproveStat;
import com.reimb.pojo.Remibursment;
import com.reimb.pojo.Users;

public interface DAO {
	public Users getUser(int userID);
	public Remibursment getRemib(int reimbID);
	public ApproveStat getStatus(int statID);
}
