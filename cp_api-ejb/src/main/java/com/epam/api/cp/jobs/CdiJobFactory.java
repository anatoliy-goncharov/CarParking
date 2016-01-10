package com.epam.api.cp.jobs;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

public class CdiJobFactory implements JobFactory {

    @Inject
    @Any
    private Instance<Job> jobs;

    public Job newJob(TriggerFiredBundle triggerFiredBundle, Scheduler scheduler) throws SchedulerException {
        final JobDetail jobDetail = triggerFiredBundle.getJobDetail();
        final Class<? extends Job> jobClass = jobDetail.getJobClass();

        for (Job job : jobs) {
            if (job.getClass().isAssignableFrom(jobClass)) {
                return job;
            }
        }

        throw new RuntimeException("Cannot create a Job of type " + jobClass);
    }
}
