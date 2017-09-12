package com.reimb.servlet;

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
import com.reimb.dto.DTO;
import com.reimb.main.DBControl;
import com.reimb.pojo.RemibView;
import com.reimb.pojo.Remibursment;
import com.reimb.pojo.Users;
@SuppressWarnings("serial")
@WebServlet("/getUserInfo")
public class GetUserInfoServlet extends HttpServlet {
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("GetUserInfo GET");
		DBControl dbcon = new DBControl();
		HttpSession session =req.getSession();
		Users sessionUser=(Users)session.getAttribute("user");
		System.out.println("getting the user"+sessionUser.getFirstName()+" "+sessionUser.getLastName());
		
		if(sessionUser !=null){
			ArrayList<Remibursment> remibs=dbcon.getRemibs(sessionUser);
			ArrayList<RemibView> rv=dbcon.getRemibView(remibs);
			System.out.println("converting our user and accounts to dto");
			DTO dto =new DTO(sessionUser,remibs,rv);
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
