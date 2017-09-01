package com.ers.dao;

import java.util.ArrayList;

import com.ers.pojos.ReimbursementStatus;

public interface ReimbursementStatusDao {
	
	public ArrayList<ReimbursementStatus> getAllStatuses();
	public ReimbursementStatus getStatus();

}
