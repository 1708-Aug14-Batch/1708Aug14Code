package com.revature.andy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.andy.pojos.User;

@WebServlet("/loadMenu")
public class MenuServlet extends HttpServlet {

	final static Logger log = Logger.getLogger(MenuServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		User sessionUser = (User) session.getAttribute("User");
		
		log.debug("Current User\t" + sessionUser);
		
		if(sessionUser.getIsManager() == 1) {
			req.getRequestDispatcher("menuM.html").forward(req, resp);
		}else if(sessionUser.getIsManager() == 0){
			req.getRequestDispatcher("menuE.html").forward(req, resp);
		}	
	}
}