package com.example.batch.simple.infrastructure.employee.store;

import com.example.batch.simple.domain.employee.entity.Employee;
import com.example.batch.simple.domain.employee.entity.SalaryHistory;
import com.example.batch.simple.domain.employee.store.SalaryHistoryStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Slf4j
@RequiredArgsConstructor
public class JpaEmployeeHistoryStore implements SalaryHistoryStore {

    private final SalaryHistoryRepository repository;

    @Override
    public List<SalaryHistory> getHistories(String name) {
        // TODO : jpql이 필요해보임
        return null;
    }

    @Override
    public int giveSalaries(List<Employee> employees) {
        List<SalaryHistory> newHistories = employees.stream().map(employee -> {
            SalaryHistory history = new SalaryHistory(employee);
            history.createHistory(null);
            return history;
        }).collect(Collectors.toList());
        employees.forEach(Employee::giveSalary);

        return repository.saveAllAndFlush(newHistories).size();
    }

    @Override
    public int save(List<SalaryHistory> histories) {
        return repository.saveAllAndFlush(histories).size();
    }
}
