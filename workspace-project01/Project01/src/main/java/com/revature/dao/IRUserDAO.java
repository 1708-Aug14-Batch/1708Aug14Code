package com.revature.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.revature.model.RUser;

public interface IRUserDAO {
	
	/**
	 * CREATE
	 */
	void create(RUser user);
	
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
	void update(RUser user);

}
