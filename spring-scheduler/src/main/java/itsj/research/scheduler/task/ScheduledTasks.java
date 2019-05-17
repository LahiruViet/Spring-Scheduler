package itsj.research.scheduler.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);


    @Value("${jobs.enabled:true}")
    private boolean isEnabled;

    @Scheduled(fixedDelay = 1000)
    public void scheduleFIxedDelayTask(){
        LOGGER.info("Fixed Delay Task : "+ System.currentTimeMillis() / 1000);
    }

    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {
        LOGGER.info("Fixed rate task - " + System.currentTimeMillis() / 1000);
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void scheduleFixedRateWithInitialDelayTask() {

        long now = System.currentTimeMillis() / 1000;
        LOGGER.info("Fixed rate task with one second initial delay - " + now);
    }

    @Scheduled(cron = "0 15 10 15 * ?")
    public void scheduleTaskUsingCronExpression() {

        long now = System.currentTimeMillis() / 1000;
        LOGGER.info("schedule tasks using cron jobs - " + now);
    }

    @Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}")
    public void scheduleFIxedDelayTaskFromPropertiesFile(){
        LOGGER.info("Fixed Delay Task : "+ System.currentTimeMillis() / 1000);
    }

    @Scheduled(fixedRateString = "${fixedRate.in.milliseconds}")
    public void scheduleFixedRateTaskFromPropertiesFile() {
        LOGGER.info("Fixed rate task - " + System.currentTimeMillis() / 1000);
    }

    @Scheduled(cron = "${cron.expression}")
    public void scheduleTaskUsingCronExpressionFromPropertiesFile() {

        long now = System.currentTimeMillis() / 1000;
        LOGGER.info("schedule tasks using cron jobs - " + now);
    }

    @Scheduled(fixedDelay = 60000)
    public void cleanTempDirectory() {
        if(isEnabled) {
            LOGGER.info("Scheduled task is enabled by conditionally using a boolean flag");
        }
    }
}
