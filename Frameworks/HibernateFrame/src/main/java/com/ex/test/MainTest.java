package com.ex.test;

import com.ex.dao.HibernateDAO;

public class MainTest {

	public static void main(String[] args) {
		HibernateDAO dao = new HibernateDAO();

		dao.deleteStudent(100);
	}
}
