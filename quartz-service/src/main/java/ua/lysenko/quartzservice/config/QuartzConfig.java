package ua.lysenko.quartzservice.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.lysenko.quartzservice.job.UnblockUsersJob;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail unblockUsersJobDetail() {
        return org.quartz.JobBuilder.newJob(UnblockUsersJob.class)
                .withIdentity("unblockUsersJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger unblockUsersJobTrigger() {
        return org.quartz.TriggerBuilder.newTrigger()
                .forJob(unblockUsersJobDetail())
                .withIdentity("unblockUsersJobTrigger")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInHours(24)
                        .repeatForever())
                .build();
    }
}
