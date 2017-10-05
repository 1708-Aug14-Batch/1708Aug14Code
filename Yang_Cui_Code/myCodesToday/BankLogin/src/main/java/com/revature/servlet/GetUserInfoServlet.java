package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.DAO;
import com.revature.dao.DaoImpl;
import com.revature.dto.DTO;
import com.revature.pojo.Account;
import com.revature.pojo.User;
@WebServlet("/getUserInfo")
public class GetUserInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("GetUserInfo GET");
		//Service service = new Service();
		DAO dao = new DaoImpl();
		HttpSession session =req.getSession();
		User sessionUser=(User)session.getAttribute("user");
		System.out.println("getting the user"+sessionUser.getFirstname()+" "+sessionUser.getLastname());
		
		if(sessionUser !=null){
			ArrayList<Account> accounts=new ArrayList<Account>();
			//accounts=service.getUserAccounts(sessionUser);
			accounts=dao.getAccount(sessionUser);
			System.out.println("converting our user and accounts to dto");
			DTO dto =new DTO(sessionUser,accounts);
			ObjectMapper mapper= new ObjectMapper();
			String json=mapper.writeValueAsString(dto);
			PrintWriter out=res.getWriter();
			res.setContentType("applicaton/json");
			out.write(json);
		}else{
			res.setStatus(418);
		}
	}
}
