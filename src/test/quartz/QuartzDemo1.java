package test.quartz;

import java.util.Date;
import java.util.List;

import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzDemo1 {

	public void run(String msgid) throws Exception {

		System.out.println("------- Initializing ----------------------");

		// 1、工厂模式
		// 构建Scheduler的Factory，其中STD为Quartz默认的Factory，开发者亦可自行实现自己的Factory;Job、Trigger等组件
		SchedulerFactory sf = new StdSchedulerFactory();
		// 2、通过SchedulerFactory获得Scheduler对象
		Scheduler sched = sf.getScheduler();

		System.out.println("------- Initialization Complete -----------");

		// 3、org.quartz.DateBuilder.evenMinuteDate <下一分钟> -- 通过DateBuilder构建Date
		// Date runTime = DateBuilder.evenMinuteDate(new Date());
		Date runTime = DateBuilder.nextGivenSecondDate(null, 5);

		System.out.println("------- Scheduling Job  -------------------");

		// 4、org.quartz.JobBuilder.newJob --通过JobBuilder构建Job
		JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group1").usingJobData("msgid", msgid)
				.build();

		// 5、通过TriggerBuilder进行构建
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
				.usingJobData("sysid", "sysid001").startAt(runTime)
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).withRepeatCount(20))
				.build();

		// 6、工厂模式，组装各个组件<JOB，Trigger>
		sched.scheduleJob(job, trigger);

		// [group1.job1] will run at:
		System.out.println(job.getKey() + " will run at: " + runTime);

		// 7、start
		sched.start();

		System.out.println("------- Started Scheduler -----------------");

		System.out.println("------- Waiting 65 seconds... -------------");
		try {
			// wait 65 seconds to show job
			Thread.sleep(15L * 1000L);
			// executing...
		} catch (Exception e) {
			//
		}

		// shut down the scheduler
		System.out.println("------- Shutting Down ---------------------");
		// 8、通过Scheduler销毁内置的Trigger和Job
		sched.shutdown(true);
		System.out.println("------- Shutdown Complete -----------------");
	}

	public static void main(String[] args) {
		QuartzDemo1 qd = new QuartzDemo1();
		try {
			qd.run("aaa");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 从数据库中找到已经存在的job，并重新开户调度
	 */
	public static void resumeJob() {
		try {

			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
			Scheduler scheduler = schedulerFactory.getScheduler();
			// ①获取调度器中所有的触发器组
			List<String> triggerGroups = scheduler.getTriggerGroupNames();
			// ②重新恢复在tgroup1组中，名为trigger1_1触发器的运行
			for (int i = 0; i < triggerGroups.size(); i++) {
				List<String> triggers = scheduler.getTriggerGroupNames();
				for (int j = 0; j < triggers.size(); j++) {
					Trigger tg = scheduler.getTrigger(new TriggerKey(triggers.get(j), triggerGroups.get(i)));
					// ②-1:根据名称判断
					if (tg instanceof SimpleTrigger && tg.getDescription().equals("tgroup1.trigger1_1")) {
						// ②-1:恢复运行
						scheduler.resumeJob(new JobKey(triggers.get(j), triggerGroups.get(i)));
					}
				}

			}
			scheduler.start();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
