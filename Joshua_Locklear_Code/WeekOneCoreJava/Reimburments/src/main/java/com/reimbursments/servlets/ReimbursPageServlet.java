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
 * Servlet implementation class ReimbursPageServlet
 */
@WebServlet("/Reimbursement")
public class ReimbursPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(ReimbursPageServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbursPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.debug("info");
		Service service = new Service();
		
		HttpSession session = request.getSession();
		Users sessionUser = (Users) session.getAttribute("user");
		ArrayList<Users> userLists = service.getAllUsers();
		DTO dto = new DTO();
		ArrayList<Reimburs> reim = new ArrayList<Reimburs>();
		if(sessionUser != null) {

			if(sessionUser.getIsManager() == 0) {
			reim = service.getUserReimbursements(sessionUser);
			}
			else if(sessionUser.getIsManager() == 1) {
				reim = service.getAllReimbursements();
			}
			dto.setUser(sessionUser);
			
			dto.setAccounts(reim);

			dto.setUserList(userLists);
			log.debug(userLists);
			
			log.debug("Going to dto");
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(dto);
			
			log.debug(sessionUser.toString());
			log.debug(reim.size());
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
		Service service = new Service();
		HttpSession session = request.getSession();
		Users sessionUser = (Users) session.getAttribute("user");
		log.debug("In the approve or deny post");
		
		if (sessionUser.getIsManager() == 1){
			int resId = sessionUser.getUserid();
			Map<String,String[]> myMap = request.getParameterMap();
			Set<String> keys = myMap.keySet();

			ObjectMapper jackson = new ObjectMapper();
			Object obj = keys.toArray()[0];

			ArrayList<String> list = jackson.readValue((String)obj, ArrayList.class);

			log.debug(list.toString());
			String notes = new String(list.get(0));
			String r_id = list.get(1);
			int Sr_id = Integer.parseInt(r_id);
			int re_id = Integer.parseInt(list.get(2));
			service.ApporDeny(resId, notes, Sr_id, re_id);

		}
		//doGet(request, response);
	}

}
