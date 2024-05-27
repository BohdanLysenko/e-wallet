package ua.lysenko.quartzservice.service;

import common.grpc.users.UserServiceGrpc;
import common.grpc.users.UserUnblockRequest;
import common.grpc.users.UserUnblockResponse;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lysenko.quartzservice.entity.JobHistory;
import ua.lysenko.quartzservice.repository.JobHistoryRepository;

import java.util.Date;

@GRpcService
@Slf4j
public class QuartzService {
    @Autowired
    UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    @Autowired
    JobHistoryRepository jobHistoryRepository;

    public boolean unblockAllUsers() {
        UserUnblockRequest request = UserUnblockRequest.newBuilder()
                .build();
        UserUnblockResponse response = userServiceBlockingStub.unblockAllUsers(request);

        if (response.getSuccess()) {
            log.warn("All users have been unlocked successfully.");
            return true;
        } else {
            log.warn("Failed to unlock users.");
            return false;
        }
    }

    public void storeJobHistory(JobExecutionContext context, JobExecutionException jobException) {
        JobDetail jobDetail = context.getJobDetail();
        String jobClassName = (jobDetail != null) ? jobDetail.getJobClass().getName() : null;
        Date fireTime = context.getFireTime();
        String status = (jobException == null) ? "Success" : "Fail";
        String errorMessage = (jobException != null) ? jobException.getMessage() : null;

        JobHistory history = JobHistory.builder()
                .runTime(context.getJobRunTime())
                .jobClass(jobClassName)
                .fireTime(fireTime)
                .status(status)
                .errorMessage(errorMessage)
                .build();

        jobHistoryRepository.save(history);
    }
}
