package com.ex.main;

import java.util.ArrayList;

import com.ex.dao.DAOImplementation;
import com.ex.pojos.Example;

public class Main {

	public static void main(String[] args) {
		DAOImplementation dao = new DAOImplementation();
		//int id = dao.getID("stored");
		//System.out.println(id);
		//System.out.println(dao.addExample("Cersei", "Lannister"));
		ArrayList<Example> list = dao.getAll();
		for(Example ex : list) {
			System.out.println(ex.toString());
		}
	}

}
