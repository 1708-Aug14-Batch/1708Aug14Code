package com;

import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.CronScheduleBuilder.*;

public class QuartzMain {

	public static void main(String[] args) {
		try {
			System.out.println("Inside main");
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
			JobDetail job = JobBuilder.newJob(Mailer.class).withIdentity("MailJob", "FuckinMail").build();
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("MailTrigger", "FuckinMail")
					.withSchedule(weeklyOnDayAndHourAndMinute(DateBuilder.FRIDAY, 9, 55)).build();
			scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException se) {
			se.printStackTrace();
		}
	}

}
