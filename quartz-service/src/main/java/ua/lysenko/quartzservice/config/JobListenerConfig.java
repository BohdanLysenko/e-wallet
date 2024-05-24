package ua.lysenko.quartzservice.config;

import jakarta.annotation.PostConstruct;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;
import ua.lysenko.quartzservice.listener.UnblockUsersJobFinishedListener;
import ua.lysenko.quartzservice.service.QuartzService;

@Component
public class JobListenerConfig {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @Autowired
    QuartzService quartzService;

    @PostConstruct
    public void addListeners() throws SchedulerException {

        schedulerFactoryBean.getScheduler()
                .getListenerManager()
                .addJobListener(new UnblockUsersJobFinishedListener(quartzService));
    }
}