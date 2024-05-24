package ua.lysenko.quartzservice.listener;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.springframework.stereotype.Component;
import ua.lysenko.quartzservice.service.QuartzService;

@Component
@Slf4j
public class UnblockUsersJobFinishedListener implements JobListener {


    private final QuartzService quartzService;

    public UnblockUsersJobFinishedListener(QuartzService quartzService) {
        this.quartzService = quartzService;
    }

    @Override
    public String getName() {
        return "unblockUsersJobFinishedListener";
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        quartzService.storeJobHistory(context, jobException);
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
    }
}