package com.example.batch.simple.infrastructure.employee.store;

import com.example.batch.simple.domain.employee.entity.Employee;
import com.example.batch.simple.domain.employee.store.EmployeeStore;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaEmployeeStore implements EmployeeStore {

    private final EmployeeRepository repository;

    @Override
    public List<Employee> getEmployees(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.ASC, "id"));
        Page<Employee> result = repository.findAll(pageable);
        return result.getContent();
    }

    @Override
    public Optional<Employee> getEmployee(String name) {
        return repository.findByName(name).stream().findFirst();
    }
}
