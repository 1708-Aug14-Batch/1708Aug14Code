package com.ex.run;

import java.util.ArrayList;

import com.ex.dao.DAOImpl;
import com.ex.pojos.Example;

public class Test {
	
	public static void main(String[] args) {
		DAOImpl dao = new DAOImpl();
//		int id = dao.getID("Genesis");
//		System.out.println(id);
		
		// testing insert
		//dao.addExample("Abe", "Lincoln");
		
		//test get all elements - statement
//		ArrayList<Example> list = dao.getAll();
//		for(Example ex:list) {
//			System.out.println(ex.toString());
//		}
		
//		String name = dao.getPerson(0);
//		System.out.println(name);
		
		ArrayList<Example> list = dao.getFaveSongs();
		for(Example ex:list) {
			System.out.println(ex.toStringSong());
		}
		
	}

}
