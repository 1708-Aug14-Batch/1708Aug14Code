package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	
	//if you use get, password and username goes into the url... not good
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("username");
		String pass = req.getParameter("pass");
		out.print("<h1> Whelcome " + name + "!<h1>");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("username");
		String pass = req.getParameter("pass");
		out.print("<h1> Whelcome " + name + "!<h1>");
		
		//Get Param Names
		Enumeration<String> paramNames = req.getParameterNames();
		out.println("<br> Get Paramater Names <br>");
		while(paramNames.hasMoreElements()) {
			String param = paramNames.nextElement();
			String value = req.getParameter(param);
			out.println("<br>" + param + ": " + value);
		}
		
	}
	
}
