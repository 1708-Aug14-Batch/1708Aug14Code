package com.reimbursments.servlets;

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
import com.reimbursments.dto.DTO;
import com.reimbursments.pojos.Reimburs;
import com.reimbursments.pojos.Users;
import com.reimbursments.service.Service;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/getUserInfo")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("getting user info");
		Service service = new Service();
		
		HttpSession session = request.getSession();
		Users sessionUser = (Users) session.getAttribute("user");
		DTO dto = new DTO();
//		System.out.println("getting user from session " + sessionUser.toString());
		if(sessionUser != null) {
			ArrayList<Reimburs> reim = new ArrayList<Reimburs>();
			System.out.println("Converting our user and accounts to dto");
			dto.setUser(sessionUser);
			dto.setAccounts(reim);
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(dto);
			
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			out.write(json);
		}
		else {
			response.setStatus(418);
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
