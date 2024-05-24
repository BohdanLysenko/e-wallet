package ua.lysenko.quartzservice.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lysenko.quartzservice.service.QuartzService;

@Component
@Slf4j
public class UnblockUsersJob implements Job {

    @Autowired
    private QuartzService quartzService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        quartzService.unblockAllUsers();
    }
}