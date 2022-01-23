package com.example.batch.simple.batch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class BatchManager {

    private final JobLauncher jobLauncher;
    private final ApplicationContext applicationContext;
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");

    public boolean hasJob(String name) {
        return applicationContext.containsBean(name);
    }

    public void runJob(String name, String regId) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        if (!hasJob(name)) {
            log.error("[{}] not found", name);
            return;
        }

        Map<String, JobParameter> jobParameterMap = new HashMap<>();
        jobParameterMap.put("date", new JobParameter(ZonedDateTime.now().format(DATE_PATTERN)));
        jobParameterMap.put("regId", new JobParameter(regId));

        JobParameters jobParameters = new JobParameters(jobParameterMap);
        JobExecution jobExecution = jobLauncher.run(applicationContext.getBean(name, Job.class), jobParameters);

        while(jobExecution.isRunning()) {
            log.info("[{}] isRunning", name);
        }

        log.info("[{}] isFinished", name);
    }

}
