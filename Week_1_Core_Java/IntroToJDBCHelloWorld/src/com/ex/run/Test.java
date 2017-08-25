package com.ex.run;

import java.util.ArrayList;

import com.ex.dao.DAOImpl;
import com.ex.pojos.Example;

public class Test {

	public static void main(String[] args) {
		
		DAOImpl dao = new DAOImpl();
//		int id = dao.getID("stored");
//		System.out.println(id);
//		
//		String id2 = dao.getName(23);
//		System.out.println(id2);
		
		//Testing add to db
		
//		int x = dao.addExample("wow this is cool", "and awesome");
//		System.out.println(x);
		
		ArrayList<Example> list = dao.getAllSong();
		for(Example i: list)
			System.out.println(i.toStringSongName());
	}

}
