package com.ex.run;

import java.util.ArrayList;

import com.ex.dao.DAOImpl;
import com.ex.pojos.Example;

public class Test {
	
	public static void main(String[] args) {
		
		DAOImpl dao = new DAOImpl();
		//int id = dao.getID("Genesis");
		//System.out.println(id);
		
		//testing add to db
		//int x = dao.addExample("wow this is", "awesome");
		//System.out.println(x);
		
		//test get all statements
		//ArrayList<Example> list = dao.getAll();
		//for(Example ex: list) {
		//	System.out.println(ex.toString());
		//}
		
		String personName = dao.getPersonID(1);
		System.out.println(personName);
		
		ArrayList<Example> albumTList = dao.getAllAlbumTitle();
		for(Example ex: albumTList) {
			System.out.println(ex.albumsToString());
		}
	}

}
