package com.ers.pojos;

public class Status {
	
	public static final int PENDING = 1;
	public static final int APPROVED = 2;
	public static final int DENIED = 3;
	
	public static String getName(int statusId) {
		
		switch (statusId) {
		case PENDING:
			return "Pending";
		case APPROVED:
			return "Approved";
		case DENIED:
			return "Denied";
		default:
			return null;
		}
	}
}
