package testing;

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

import com.bank.pojos.User;
import com.bank.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/loginmessagetest")
public class LoginMessageServlet extends HttpServlet{

	//see github master repo for notes
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		System.out.println("testing -- post");
		
		Map<String, String[]> myMap = req.getParameterMap();
		
		Set<String> txObject = myMap.keySet();
		
		ObjectMapper jackson = new ObjectMapper();
		
		Object obj = txObject.toArray()[0];
		ArrayList<String> tx = jackson.readValue((String)obj,ArrayList.class);
		
		HttpSession sesh = req.getSession();
		Service s = new Service();
		
		String email = tx.get(0);
		String pass = tx.get(1);
		
		int id = s.validateUser(email);
		System.out.println("id = " + id);
		
		if(id<0)
		{	
			String json = "fail";
			PrintWriter out = res.getWriter();
			res.setContentType("application/json");
			out.write(json);
		}
		else {
			User u = s.loginForServlet(id, pass);
			if(u == null)
			{
				String json = "pass";
				PrintWriter out = res.getWriter();
				res.setContentType("application/json");
				out.write(json);
			}
			else {
				
				sesh.setAttribute("user", u);
				
				
				ObjectMapper mapper = new ObjectMapper();
				
				String json = mapper.writeValueAsString(u);
				PrintWriter out = res.getWriter();
				res.setContentType("application/json");
				out.write(json);
			}
		}
		
	}
}
