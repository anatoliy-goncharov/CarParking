package com.epam.api.cp.jobs;

import com.epam.api.cp.ejb.SpacerExpiredInfoService;
import org.apache.log4j.Logger;
import org.quartz.*;

import javax.ejb.EJB;

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class SpacerExpiredInfoJob implements Job {

    private static final Logger logger = Logger.getLogger("SpacerExpiredInfoJob");

    @EJB
    SpacerExpiredInfoService service;

    @EJB
    private QuartzJobFactory quartzJobFactory;

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //todo Make system property
        boolean isEnable = false;

        logger.info("SpacerExpiredInfoJob - start: enable = " + isEnable);


        if (isEnable) {
            try {
                service.makeAddInfoexpired();
            } catch (Exception e) {
                logger.error("SpacerExpiredInfoJob - error", e);
                throw new JobExecutionException(e);
            } finally {
                try {
                    quartzJobFactory.resumeJob(SpacerExpiredInfoJob.class);
                    quartzJobFactory.resumeJob(SpacerExpiredInfoJob.class);
                } catch (SchedulerException e) {
                    logger.error("SpacerExpiredInfoJob - error", e);
                    throw new JobExecutionException(e);
                }
            }
        }
        logger.info("SpacerExpiredInfoJob - end");
    }
}
