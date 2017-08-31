package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/HelloWorld")
public class HelloWorld extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h1> Hello Servlets!</h1>"
				+ "<br><br>"
				+ "<ul><li>this is a list</li></ul>");
		
	}

	
	
//	protected void doPost(HttpServletRequest req,
//			HttpServletResponse resp) throws 
//			ServletException, IOException{
//	}
	
	
}
