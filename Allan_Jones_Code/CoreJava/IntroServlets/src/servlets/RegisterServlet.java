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
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("username");
		String pw = req.getParameter("passwword");
		
		out.print("<h1>Welcome " + name + "!</h1>");
		
		// get param names
		Enumeration<String> paramNames = req.getParameterNames();
		while(paramNames.hasMoreElements()) {
			out.println("<br>");
			String param = paramNames.nextElement();
			String value = req.getParameter(param);
			out.println(param + ": " + value);
		}
	}
		
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			
			String name = req.getParameter("username");
			String pw = req.getParameter("passwword");
			
			out.print("<h1>Welcome " + name + "!</h1>");
			
			// get param names
			Enumeration<String> paramNames = req.getParameterNames();
			while(paramNames.hasMoreElements()) {
				out.println("<br>");
				String param = paramNames.nextElement();
				String value = req.getParameter(param);
				out.println(param + ": " + value);
			}
		
		
	}
}
