package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HelloWorld")
public class HelloWorld extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Hello Servlets!</h1>"
					+ "<br></br>" + "<ul><li>this is a list</li></ul>");
		// TODO Auto-generated method stub
		
	}
	
//	protected void doPost(HttpServletRequest req, HttpServletResponse res )
//			throws ServletException, IOException{
//		
//	}
	
	
	

}
