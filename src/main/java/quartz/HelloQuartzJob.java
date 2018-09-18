package quartz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class HelloQuartzJob implements Job {
	

	public HelloQuartzJob() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void execute(JobExecutionContext context) 
            throws JobExecutionException {
        String instName = context.getJobDetail().getKey().getName();
        String groupName = context.getJobDetail().getKey().getGroup();
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String myDescription = dataMap.getString("myDescription");
        int myValue = dataMap.getInt("myValue");
        List<String> myArray = (List<String>) dataMap.get("myArray");
        System.out.println("---> Instance = " + instName + ", group = " + groupName
                + ", description = " + myDescription + ", value =" + myValue
                + ", array item[0] = " + myArray.get(0));
        System.out.println("Runtime: " + new Date().toString() + " <---");
    }
	
	

}
