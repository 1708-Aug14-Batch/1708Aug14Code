package com.example.run;

import com.example.dao.DaoImpl;
import com.example.pojos.Example;

public class Test {
	
	public static void main(String[] args) {
		
		DaoImpl dao = new DaoImpl();
		
		//System.out.println(dao.getId("Nathan"));
		//System.out.println(dao.getName(21));
		//System.out.println(dao.addExample("James", "Bond"));

		for (Example e : dao.getAll()) {
			System.out.println(e);
		}
	}

}
