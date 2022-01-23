package com.example.batch.simple.application.employee;

import com.example.batch.simple.domain.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeFacade {

    private final EmployeeService employeeService;


}
