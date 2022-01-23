package com.example.batch.simple.domain.employee.store;

import com.example.batch.simple.domain.employee.entity.Employee;
import com.example.batch.simple.domain.employee.entity.SalaryHistory;

import java.util.List;

public interface SalaryHistoryStore {

    List<SalaryHistory> getHistories(String name);

    int giveSalaries(List<Employee> employees);

    int save(List<SalaryHistory> history);
}
