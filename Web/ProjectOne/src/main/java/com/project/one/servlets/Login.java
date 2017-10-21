package com.project.one.servlets;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.one.pojos.Employee;
import com.project.one.service.Service;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new FileReader("/ProjectOne/src/main/webapp/LoginPortal.html"));
//		String text;
//		String str = "<div style=\"background-color:red; text: strong;\">Email was invalid, please try again</div>";
//		while((text = br.readLine()) != null) {
//			if(text.equals("<body>")) {
//				text=text.concat(str);
//			}
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service serve = new Service();
		Employee empl;

		String email = request.getParameter("email");
		String pwd = request.getParameter("password");

		System.out.println(email+pwd);

		if((empl = Service.login(email))!=null) {
			//TODO	RequestDispatcher rd = request.getRequestDispatcher("loggedin");
			//	rd.forward(request, response);
			if(Service.validate(empl, pwd)) {
				if(empl.getMngr()==0) {
					//CookieHolder employee = new CookieHolder(empl);
					//Cookie employee = new Cookie(email);
					//response.addCookie(employee);
					RequestDispatcher rd = request.getRequestDispatcher("EmployeePortal.html");
					
					rd.forward(request, response);
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("managerHome");
					rd.forward(request, response);
				}
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("Login");
				rd.forward(request, response);
			}
		}
		else {
			response.sendRedirect("Login");
		}
	}

}
