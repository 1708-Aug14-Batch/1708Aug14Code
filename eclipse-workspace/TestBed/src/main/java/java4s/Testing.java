package java4s;

import java.util.TimerTask;

import javaConstants.Constants;

public class Testing{
	public void run()
	 {
//		System.out.println("It fired");
		String emails = "Hello [insert Trainer Here],\n\nThis is an automatic notification that the evaluation period for this week has passed " +
		"and you have not submitted grades for this week.\nPlease submit the grades for your batch As Soon As Possible. " +
		"You can enter your grades into Caliber here: http://localhost:8989/caliber/#/vp/assess";
		GMailServer sender = new GMailServer(Constants.setFrom, Constants.setPassword);
	 
	             try {
	     sender.sendMail("Grade Submission Reminder",emails,Constants.setFrom,Constants.emailTO);
	 }
	                   catch (Exception e) {
	      e.printStackTrace();
	 }  
	 
	 System.out.println("Email Sent Succesfully...");
	 
	         }
}
