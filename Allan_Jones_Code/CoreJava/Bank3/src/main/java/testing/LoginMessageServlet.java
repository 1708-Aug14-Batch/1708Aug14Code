package testing;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank3.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/loginmessagetest")
public class LoginMessageServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Testing -- POST servlet");
		
		// grap all params, even though in this case it is only 1 JSON string
		Map<String, String[]> myMap = req.getParameterMap();
		
		// get the keyset from the map
		Set<String> txObject = myMap.keySet();
		
		// use Jackson. API for converting JSON to java
		ObjectMapper jackson = new ObjectMapper();
		
		// convert keyset into an array, then get what we need from it
		Object obj = txObject.toArray()[0];
		ArrayList<String> tx = jackson.readValue((String)obj, ArrayList.class);
		
		HttpSession session = req.getSession();
		Service service = new Service();
		
		String username = tx.get(0);
		String pass = tx.get(1);
		
		int id = service.validateUser(username, pass);
		System.out.println("id = " + id);
		String json = "";
		
		if(id == 0) {
			json = "Invalid user. Please try again.";
			
		} else {
			json = "Valid user.  Success!";
			// call new ajax function to move to "home page" using new servlet

		}
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
	}
}
