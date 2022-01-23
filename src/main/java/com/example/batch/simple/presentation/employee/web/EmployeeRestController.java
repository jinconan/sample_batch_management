package com.example.batch.simple.presentation.employee.web;

import com.example.batch.simple.application.employee.EmployeeFacade;
import com.example.batch.simple.batch.BatchManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeRestController {

    private final EmployeeFacade employeeFacade;
    private final BatchManager batchManager;

    @GetMapping("{regId}")
    public ResponseEntity<Void> manualRunJob(@PathVariable String regId) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        batchManager.runJob("giveSalaryWithHistoryJob", regId);
        return ResponseEntity.ok().build();
    }
}
