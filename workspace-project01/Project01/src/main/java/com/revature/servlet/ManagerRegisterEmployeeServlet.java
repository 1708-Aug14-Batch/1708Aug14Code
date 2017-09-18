package com.revature.servlet;

import java.io.IOException;
import java.util.Enumeration;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.RegisterEmpDTO;
import com.revature.dto.UserEditDTO;
import com.revature.service.ReimbursementService;

@WebServlet("/manager-register-employee")
public class ManagerRegisterEmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = -3344165540846554620L;
	private ReimbursementService service = new ReimbursementService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("partial/manager/register-employee.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Enumeration<String> requestParams = request.getParameterNames();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = requestParams.nextElement();
		RegisterEmpDTO registrationData = (RegisterEmpDTO) mapper.readValue(jsonString, RegisterEmpDTO.class);
		this.service.registerEmployee(registrationData);
		this.sendEmail(registrationData.getEmail(), registrationData.getPassword());
	}

	private void sendEmail(String email, String tempPassword) {
		if (email == null) {
			throw new IllegalArgumentException("Email cannot be null");
		}
		if (tempPassword == null) {
			throw new IllegalArgumentException("Temporary password cannot be null");
		}
		String to = email;

		String from = "Manager";
		final String username = "ade61badc7a9b9";
		final String password = "85aa802ea2d5c7";

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.mailtrap.io");
		properties.put("mail.smtp.port", "465");

		// Get the Session object.
		Session session = Session.getInstance(properties,
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
			message.setSubject("Complete Account Registration");

			// Now set the actual message
			message.setText("Your manager has registered your account. "
					+ "Please log on and change your password. "
					+ "Your temporary password is " + tempPassword + ".");

			// Send message
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
