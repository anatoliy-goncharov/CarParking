package com.epam.api.cp.jobs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.spi.JobFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.Collections;

@Singleton
@Startup
public class QuartzJobFactory {
    private static final Log logger = LogFactory.getLog(QuartzJobFactory.class);

    private Scheduler scheduler;

    @Inject
    private JobFactory cdiJobFactory;

    @PostConstruct
    public void startQuartz() {
        try {
            SchedulerFactory sf = new StdSchedulerFactory();

            scheduler = sf.getScheduler();
            scheduler.setJobFactory(cdiJobFactory);

            startJob(SpacerExpiredInfoJob.class);

            scheduler.start();
            logger.info("Scheduler started successfully");
        } catch (SchedulerException se) {
            logger.error(se, se);
        }
    }

    @PreDestroy
    public void stopQuartz() {
        try {
            scheduler.shutdown(true);
            logger.info("Scheduler closed successfully");
        } catch (SchedulerException se) {
            logger.error(se, se);
        }
    }

    public void startJob(Class clazz) throws SchedulerException {
        String jobName = clazz.getSimpleName();
        JobDetail job = JobBuilder.newJob(clazz).withIdentity(jobName).build();
        //todo Need to realize property file for read settings for our application
        String cronExpression = "0/5 * * * * ?";
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName)
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).startNow().build();
        scheduler.scheduleJob(job, Collections.singleton(trigger), true);
        logger.info(jobName + " scheduled start successfully");
    }

    public void resumeJob(Class clazz) throws SchedulerException {
        String jobName = clazz.getSimpleName();
        if (!scheduler.checkExists(JobKey.jobKey(jobName))) {
            startJob(clazz);
        }
        logger.info(jobName + " scheduled resume successfully");
    }

    public void stopJob(Class clazz) throws SchedulerException {
        String jobName = clazz.getSimpleName();
        scheduler.deleteJob(JobKey.jobKey(jobName));
        logger.info(jobName + " scheduled stop successfully");
    }
}
