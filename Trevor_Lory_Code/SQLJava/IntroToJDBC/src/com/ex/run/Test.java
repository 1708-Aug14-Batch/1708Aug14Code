package com.ex.run;

import java.util.ArrayList;

import com.ex.dao.DAOImpl;
import com.ex.pojos.Example;

public class Test {

	public static void main(String[] args) {
		DAOImpl dao = new DAOImpl();
		//int id = dao.getID("testing");
		//System.out.println(id);
		
		//int x = dao.addExample("Wow this is", "awesome");
		//System.out.println(x);
		
		//ArrayList<Example> list = dao.getAll();
		//for(Example ex : list) {
			//System.out.println(ex.toString());
		//}
		
		//String s = dao.getName(21);
		//System.out.println(s);
		
		ArrayList<Example> list2 = dao.getAllWithTitle();
		for(Example ex : list2) {
			System.out.println(ex.toStringTitle());
		}
	}
	
}
