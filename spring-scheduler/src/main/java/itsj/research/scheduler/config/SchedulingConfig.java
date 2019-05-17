package itsj.research.scheduler.config;

import itsj.research.scheduler.conditionalTask.ScheduledJob;
import itsj.research.scheduler.conditionalTask.ScheduledJobProd;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@Configuration
public class SchedulingConfig {

    @Bean
    @ConditionalOnProperty(value = "jobs.enabled", matchIfMissing = true, havingValue = "true")
    public ScheduledJob scheduledJob() {
        return new ScheduledJob();
    }

    @Profile("prod")
    @Bean
    public ScheduledJobProd scheduledJobProd() {
        return new ScheduledJobProd();
    }
}
