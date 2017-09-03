package com.revature.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.revature.model.Status;

public interface IStatusDAO {
	
	/**
	 * READ
	 */
	Status read(String name);
	
	/**
	 * READ ALL
	 */
	ArrayList<Status> readAll();

}
