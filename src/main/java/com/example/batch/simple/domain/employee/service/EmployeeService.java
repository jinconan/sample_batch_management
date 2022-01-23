package com.example.batch.simple.domain.employee.service;

import com.example.batch.simple.domain.employee.entity.Employee;
import com.example.batch.simple.domain.employee.store.SalaryHistoryStore;
import com.example.batch.simple.domain.employee.store.EmployeeStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeStore employeeStore;
    private final SalaryHistoryStore salaryHistoryStore;

    public List<Employee> getEmployees(int page, int pageSize) {
        return employeeStore.getEmployees(page, pageSize);
    }

    public int giveSalaries(List<Employee> employees) {
        return salaryHistoryStore.giveSalaries(employees);
    }
}
