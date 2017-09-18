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
import com.reimb.pojo.Users;

@WebServlet("/getAllUserInfo")
public class GetAllUserServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		DBControl dbcon = new DBControl();
		ArrayList<Users> all=dbcon.getEveryOne();
		HttpSession session =req.getSession();
		Users sessionUser=(Users)session.getAttribute("user");
		if(sessionUser.getIsMananger()){
			DTO dto =new DTO(sessionUser,all,null,null);
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
