package com.rev.run;

import java.util.ArrayList;

import com.rev.dao.DAOImpl;
import com.rev.pojos.Example;

public class Test {

	public static void main(String[] args) {
		
		DAOImpl dao = new DAOImpl();
		//String name = dao.getName(3);
		//int id = dao.addExample("new2", "name2");
//		ArrayList<Example> people = dao.getAll();
//		for(Example ex : people){
//			System.out.println(ex.toString());
//		}
//		
		dao.getAllWithSongName();
	}

}