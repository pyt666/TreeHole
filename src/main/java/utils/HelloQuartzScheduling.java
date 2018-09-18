package utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import quartz.HelloQuartzJob;
public class HelloQuartzScheduling {

	public static void main(String[] args) throws SchedulerException, InterruptedException {
		System.out.println("currentTime:" + new Date());
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler = sf.getScheduler();
		
		JobDetail job = JobBuilder.newJob(HelloQuartzJob.class).withIdentity("job1", "group1").build();
		
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("trigger1", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
				.build();
		
		job.getJobDataMap().put("myDescription", "Hello Quartz");
		job.getJobDataMap().put("myValue", 1990);
		List<String> list = new ArrayList<>();
		list.add("firstItem");
		job.getJobDataMap().put("myArray", list);
		
		scheduler.scheduleJob(job,trigger);
		scheduler.start();
		Thread.sleep(7000);
		scheduler.shutdown();
		System.out.println("currentTime:" + new Date());
	}
}
