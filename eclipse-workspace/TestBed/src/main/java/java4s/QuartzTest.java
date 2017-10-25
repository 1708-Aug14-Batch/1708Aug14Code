package java4s;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.CronScheduleBuilder.*;

import org.quartz.DateBuilder;

public class QuartzTest {

	public static void main(String[] args) throws Exception{
		try {
			Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
			sched.start();
			
			JobDetail job = JobBuilder.newJob(DBScheduler.class)
					.withIdentity("job1","group1")
					.build();
			
			Trigger trigger = TriggerBuilder.newTrigger()
					.withIdentity("trigger1", "group1")
						.withSchedule(weeklyOnDayAndHourAndMinute(DateBuilder.FRIDAY, 9, 0))
						.build();
			sched.scheduleJob(job,trigger);
			
			
			
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
