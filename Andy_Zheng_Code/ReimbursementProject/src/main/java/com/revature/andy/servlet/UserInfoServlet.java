package com.revature.andy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.andy.pojos.User;

@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet{

	final static Logger log = Logger.getLogger(UserInfoServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User sessionUser = (User) session.getAttribute("User");
		
		log.debug("Current User\t" + sessionUser);
		
		if(sessionUser!=null) {
			
			ObjectMapper mapper = new ObjectMapper();
			
			String json = mapper.writeValueAsString(sessionUser);
			
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			
			out.write(json);
			log.debug("Response\t" + json);
		}
	}
}
