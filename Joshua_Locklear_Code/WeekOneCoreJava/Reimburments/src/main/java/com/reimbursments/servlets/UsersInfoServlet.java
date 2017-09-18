package com.reimbursments.servlets;

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

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursments.DAO.DAOImpl;
import com.reimbursments.dto.DTO;
import com.reimbursments.pojos.Reimburs;
import com.reimbursments.pojos.Users;
import com.reimbursments.service.Service;

/**
 * Servlet implementation class UsersInfoServlet
 */
@WebServlet("/UserInform")
public class UsersInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(UsersInfoServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Service service = new Service();
		HttpSession session = request.getSession();
		Users sessionUser = (Users)session.getAttribute("user");
		ArrayList<Users> list = service.getAllUsers();
		ArrayList<Reimburs> reim = service.getAllReimbursements();
		DTO dto = new DTO(sessionUser, reim, list);
		if(sessionUser != null) {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(dto);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			out.write(json);
		}
		else{
			response.setStatus(418);
		}
		
			
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Service service = new Service();

		log.debug("In the new user post");
		
		
			
			Map<String,String[]> myMap = request.getParameterMap();
			Set<String> keys = myMap.keySet();

			ObjectMapper jackson = new ObjectMapper();
			Object obj = keys.toArray()[0];

			ArrayList<String> list = jackson.readValue((String)obj, ArrayList.class);
			
			String fname = list.get(0);
			String lname = list.get(1);
			String email = list.get(2);
			String password = list.get(3);

			service.createUser(fname, lname, email, password);
		//doGet(request, response);
	}

}
