package com.revature.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.model.User;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("mvc.xml");
		UserDAO dao = (UserDAOImpl) context.getBean("myDAO");
		//UserDAOImpl dao = new UserDAOImpl();
		User user = new User();
		user.setUsername("mscott");
		user.setPassword("123");
		dao.createUser(user);
	}

}
