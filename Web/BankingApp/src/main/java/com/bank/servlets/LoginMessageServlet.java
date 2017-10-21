package com.bank.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dto.DTO;
import com.bank.pojos.User;
import com.bank.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/loginMessage")
public class LoginMessageServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("We're in the loginServlet");
		HttpSession session = req.getSession();
		//grab all params even thought its really extra rn
		Map<String, String[]> map = req.getParameterMap();
		Set<String> txObject = map.keySet();

		
		//use jackson. API for converting JSON to Java
		
		ObjectMapper jackson = new ObjectMapper();
		
		// convert our keyset into an array, then
		//get what we need from it
		
		Object obj = txObject.toArray()[0];
		ArrayList<String> tx = jackson.readValue((String)obj, ArrayList.class);
		
		
		Service service = new Service();
		
		String email = tx.get(0);
		String pass = tx.get(1);
		String json = "";
		User u = service.login(email, pass);
		System.out.println(u);
		if(u == null) {
			json = "Fail";
			
		}
		else {
			DTO dto = new DTO(u, u.getAccounts());
			ObjectMapper mapper = new ObjectMapper();
			//json = mapper.writeValueAsString(dto);
			json = "SUCCESS";
			session.setAttribute("user", u);
		}
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);

	}
}
