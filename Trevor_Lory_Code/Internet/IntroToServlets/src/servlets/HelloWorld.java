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
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<h1>Hello Servlets!</h1>" +
					"<br><br>" +
					"<ul><li>This is a list</li></ul>");
		
	}
	
	//@Override
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	
	//}
	
}
