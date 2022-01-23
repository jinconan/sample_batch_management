package com.example.batch.simple.batch.configuration;

import com.example.batch.simple.batch.BatchManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@RequiredArgsConstructor
@EnableBatchProcessing
@EnableScheduling
@Slf4j
public class BatchConfiguration {

    private final BatchManager batchManager;

    public void runJob() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        batchManager.runJob("giveSalaryWithHistoryJob", "Scheduler");
    }


}
