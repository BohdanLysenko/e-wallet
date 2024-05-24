package ua.lysenko.quartzservice.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.lysenko.quartzservice.job.UnblockUsersJob;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail unlbockUsersJobDetail() {
        return org.quartz.JobBuilder.newJob(UnblockUsersJob.class)
                .withIdentity("unblockUsersJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger unblockUsersJobTrigger() {
        return org.quartz.TriggerBuilder.newTrigger()
                .forJob(unlbockUsersJobDetail())
                .withIdentity("unblockUsersJobTrigger")
                .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(0, 0))
                .build();
    }
}