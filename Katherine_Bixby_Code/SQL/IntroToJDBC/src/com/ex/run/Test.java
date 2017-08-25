package com.ex.run;

import java.util.ArrayList;

import com.ex.dao.DAOImpl;
import com.ex.pojos.Example;

public class Test {

	public static void main(String[] args) {
	
		DAOImpl dao = new DAOImpl();
		
//		int id = dao.getID("Andrew");
//		System.out.println(id);
		
//		String name = dao.getName(1);
//		System.out.println(name);

		
//		int x = dao.addExample("wow this is", "awesome");
		
		ArrayList<Example> list = dao.getAll();
		for(Example ex:list) {
			System.out.println(ex.toString());
			int songID = ex.getSong();
			dao.getSongs(songID);
		}
		
	}
	
}
