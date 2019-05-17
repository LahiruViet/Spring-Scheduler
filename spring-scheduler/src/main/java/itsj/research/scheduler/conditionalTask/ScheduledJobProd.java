package itsj.research.scheduler.conditionalTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class ScheduledJobProd {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledJob.class);

    @Scheduled(fixedDelay = 60000)
    public void conditionalScheduledTaskForProd() {
        LOGGER.info("Conditional scheduled task in Production env");
    }
}
