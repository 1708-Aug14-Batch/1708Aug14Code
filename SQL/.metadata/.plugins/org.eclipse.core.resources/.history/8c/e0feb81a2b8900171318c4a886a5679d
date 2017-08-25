package com.ex.run;

import java.util.ArrayList;

import com.ex.dao.DAOImpl;
import com.ex.pojos.Example;

public class Tester {
	
	public static void main(String[] args) {
		
		DAOImpl dao = new DAOImpl();
		/*
		int id = dao.getID("stored");
		System.out.println(id);
		
		int x = dao.addExample("Chuck", "Norris");
		System.out.println(x);
		*/
		
		ArrayList<Example> list = dao.getAll();
		for (Example ex : list)
			System.out.println(ex.toString());
	}

}
