package com.ex.test;

import com.ex.beans.Instructor;
import com.ex.dao.HibDAO;

public class MainTest {

	public static void main(String[] args) {

		HibDAO dao = new HibDAO();
		Instructor inst = new Instructor();
		
		inst.setName("Dr. Bonds");
		
		dao.addInstructor(inst);
	}

}
