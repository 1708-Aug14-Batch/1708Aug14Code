package com.jdbc.run;

import java.util.ArrayList;
import com.jdbc.dao.DAOImpl;
import com.jdbc.pojos.Example;

public class Test {

	public static void main(String[] args) {

		DAOImpl dao = new DAOImpl();
		int id = dao.getID("Andrew");
		System.out.println(id);
		String name = dao.getName(id);
		System.out.println(name);
		id = dao.addExample("Bruce", "Banner");
		System.out.println(id);
		ArrayList<Example> list = dao.getAll();
		for (Example e : list)
		{
			System.out.println(e.getFirstname() + " " + e.getLastname());
		}
	}

}
