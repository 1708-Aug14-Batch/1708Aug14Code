package com.revature.dao;

import java.util.ArrayList;

import com.revature.model.RUser;

public interface IRUserDAO {
	
	/**
	 * CREATE
	 */
	int create(RUser user);
	
	/**
	 * READ
	 */
	RUser read(String email);
	
	/**
	 * READ ALL
	 */
	ArrayList<RUser> readAll();
	
	/**
	 * UPDATE
	 */
	int update(RUser user);

}
