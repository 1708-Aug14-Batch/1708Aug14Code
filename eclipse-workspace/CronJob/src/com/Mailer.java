package com;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Mailer implements Job {
	
	private static String from = System.getenv("DEV_CALIBER_EMAIL");
	private static String pass = System.getenv("DEV_CALIBER_PASS");
	private String to = "mscott@mailinator.com";
	
//	public Mailer() {
//		from;
//		pass;
//		this.to = "mscott@mailinator.com";
//	}

	//@Override
//	public void run() {
//		this.send();
//	}

	private void send() {
		System.out.println("Inside send");
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "587");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable", "true");
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Mailer.from, Mailer.pass);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Test");
			message.setText("This is a test");
			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			System.out.println(e);
		}
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Inside execute");
		this.send();
	}

}
