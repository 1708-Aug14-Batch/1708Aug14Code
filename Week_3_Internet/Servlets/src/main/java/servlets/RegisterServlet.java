package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		
		res.setContentType("text/html"); //Means you are setting information and sending it back to the client without editing a web file. 
		PrintWriter out = res.getWriter();
		
		String name = req.getParameter("username"); //Gets the parameters from the HTML doc. The parameter is what is set in the document.
		String password = req.getParameter("pass");
		
		
		out.print("<h1> Welcome " + name + "!</h1>");
		
		//get param names
		Enumeration<String> paramNames = req.getParameterNames();
		
		while(paramNames.hasMoreElements()) {
			out.println("<br> Get parameter names <br>");
			String param = paramNames.nextElement();
			String value = req.getParameter(param);
			out.println(param + ": " + value);
		}
		
		
	}
}
