package com.ex.main;

import com.ex.dao.DAOImplementation;

public class Main {

	public static void main(String[] args) {
		DAOImplementation dao = new DAOImplementation();
		int id = dao.getID("stored");
		System.out.println(id);
	}

}
