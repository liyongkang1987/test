package test.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class HelloJob implements Job {

	private String msgid;
	private String sysid;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		JobKey jobKey = context.getJobDetail().getKey();

		int i = context.getTrigger().getMisfireInstruction();
		// JobDataMap dataMap = context.getMergedJobDataMap();//
		// .getJobDetail().getJobDataMap();

		System.out.println("Hello World! - " + jobKey + " executing at " + new Date());

		// System.out.println(context.getFireInstanceId());
		// System.out.println(context.getJobRunTime());
		// System.out.println(context.getRefireCount());
		// System.out.println(context.getResult());
		// System.out.println(context.getCalendar());
		// System.out.println(context.getFireTime());
		// System.out.println(context.getJobInstance());
		// System.out.println(context.getScheduledFireTime());
		// System.out.println(context.getMergedJobDataMap());

		// System.out.println("msgid:" + dataMap.getString("msgid"));
		// System.out.println("sysid:" + dataMap.getString("sysid"));
		System.out.println("msgid:" + msgid);
		System.out.println("sysid:" + sysid);
		System.out.println(i);
		System.out.println("=======================================");
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	public void setSysid(String sysid) {
		this.sysid = sysid;
	}

}
