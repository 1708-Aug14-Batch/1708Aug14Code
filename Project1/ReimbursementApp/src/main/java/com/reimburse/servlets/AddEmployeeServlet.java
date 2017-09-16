package com.reimburse.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimburse.pojos.User;
import com.reimburse.service.Service;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet{
	final static Logger logger = Logger.getLogger(AddEmployeeServlet.class);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{

		Service bankService = new Service();
		PrintWriter writer = res.getWriter();

		//make new user
		User user = new User();

		//update info
		user.setFirstname(req.getParameter("fn"));
		user.setLastname(req.getParameter("ln"));
		user.setUsername(req.getParameter("username"));
		user.setEmail(req.getParameter("email"));
		user.setPwd(req.getParameter("pwd"));
		user.setIsManager((byte) 0); 

		//send
		user = bankService.addUser(user);

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(user);
		res.setContentType("application/json");
		writer.print(json);

		logger.info("POST added employee: "+user.toString());
		sendEmail(user);
	}

	private void sendEmail(User user) {
		// Recipient's email ID needs to be mentioned.
		String to = user.getEmail();

		// Sender's email ID needs to be mentioned
		String from = "steven.leighton95@gmail.com";
		final String username = "steven.leighton95@gmail.com";//change accordingly
		final String password = "kaexrmnbykkvlakk";//change accordingly

		// Assuming you are sending email through gmail
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("Employee Login Info for ERS");

			// Now set the actual message
			message.setText("Hello, you have been added to the ERS system!"+
					" Login by using your username ("+user.getUsername()+") and password ("+user.getPwd()+")."+
					" Thank you!");

			// Send message
			Transport.send(message);

			logger.info("Email login info sent to: "+user.getEmail());

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
