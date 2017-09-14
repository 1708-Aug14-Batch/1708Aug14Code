package com.revature.main;

import com.revature.beans.User;
import com.revature.dao.HibernateDAO;

public class Main {
	public static void main(String[] args) {
		HibernateDAO hibernateDAO = new HibernateDAO();
		for (int i=0; i<5; i++) {
			User user = new User("first" + i, "last" + i, "email" + i, "password" + i);
			hibernateDAO.addUser(user);
		}
	}
}
