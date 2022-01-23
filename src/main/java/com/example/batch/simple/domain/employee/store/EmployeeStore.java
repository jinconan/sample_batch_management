package com.example.batch.simple.domain.employee.store;

import com.example.batch.simple.domain.employee.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeStore {

    List<Employee> getEmployees(int page, int pageSize);

    Optional<Employee> getEmployee(String name);
}
