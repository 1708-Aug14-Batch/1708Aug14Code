package com.rev.main;

import com.rev.dao.DBDAO;

public class Driver {
	public static void main(String[] args) {
		DBDAO d = new DBDAO();
		
		String first = d.getFirstFromId(1);
		String last = d.getLastFromId(1);
		
		System.out.println(first + " " + last);
		
		d.disconnect();
	}
}
