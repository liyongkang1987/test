package test.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzDemo2 {

	public static Scheduler scheduler;

	public static void main(String[] args) throws SchedulerException {

		scheduler = StdSchedulerFactory.getDefaultScheduler();

	}

}
