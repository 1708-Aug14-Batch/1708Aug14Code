package com.reimbursement.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reimbursement.pojos.User;
import com.reimbursement.service.Service;

public class CreateAccountServlet extends HttpServlet {

	private Service runApp = new Service();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String pword = request.getParameter("pword");
		String pword_c = request.getParameter("pword_c");
		boolean isMgr = request.getParameter("manager") != null;
		System.out.println("Hello, " + fname + " " + lname +". Manager: "+isMgr);
		System.out.println(pword + " : " + pword_c);
		
		User tmp = runApp.validateEmail(email);
		if (tmp != null) {
			System.out.println("Email is already taken...");
		} 
		else if (!pword.equals(pword_c)) {
			System.out.println("Passwords don't match...");
		}
		else {
			//TODO: Create a randomly generated password.
			int id = runApp.registerEmployee(fname, lname, email, pword, isMgr);
			/*
			HttpSession session = request.getSession(false);
			User mgr = (User)session.getAttribute("user");

			String to = email;
			String from = mgr.getEmail();
			String host = "local";
			String pass = "PASSWORD";
			String subject = "Login Credentials";
			String body = "Hello";
			
			Properties props = System.getProperties();
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.user", from);
	        props.put("mail.smtp.password", pass);
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");

	        Session es = Session.getDefaultInstance(props);
	        MimeMessage message = new MimeMessage(es);

	        try {
	            message.setFrom(new InternetAddress(from));
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            message.setSubject(subject);
	            message.setText(body);
	            Transport transport = es.getTransport("smtp");
	            transport.connect(host, from, pass);
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();
	        }
	        catch (AddressException ae) {
	            ae.printStackTrace();
	        }
	        catch (MessagingException me) {
	            me.printStackTrace();
	        }
			*/
		}
		response.sendRedirect("manager.html");

	}
}
