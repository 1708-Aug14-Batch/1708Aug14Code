package java4s;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import javaConstants.Constants;

public class DBScheduler implements Job{



	Testing test = new Testing();
	
	public void callScheduler() throws Exception
	{

		

		ReadPropertiesFile.readConfig();		
		test.run();
//		timer.schedule(test, c.getTime(), 60000);

	}


	public long getTimePrecision(String value) throws Exception
	{
		System.out.println(value);
		long  l = 0;
		String val="";
		try
		{
			if(value.endsWith("d") || value.endsWith("D"))
			{
				val  = value.substring(0,value.length()-1);
				l = Long.parseLong(val) * 24 * 60 * 60 * 1000;
			}

			else if(value.endsWith("h") || value.endsWith("H"))
			{

				val  = value.substring(0,value.length()-1);
				l = Long.parseLong(val) * 60 * 60 * 1000;

			}
			else if(value.endsWith("m") || value.endsWith("M"))
			{
				val  = value.substring(0,value.length()-1);
				l = Long.parseLong(val) * 60 * 1000;
			}
			else if(value.endsWith("s") || value.endsWith("S"))
			{

				val  = value.substring(0,value.length()-1);
				l = Long.parseLong(val) * 1000;
			}
			else
			{

				l = Long.parseLong(value);
			}

		}
		catch(Exception e)
		{

			throw new Exception(e);
		}

		return l;
	}
	



	public void execute(JobExecutionContext arg0) throws JobExecutionException {

		
		try {
			DBScheduler dbs = new DBScheduler();
			dbs.callScheduler();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
}
