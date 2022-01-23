package com.example.batch.simple.repository;

import com.example.batch.simple.domain.employee.entity.Employee;
import com.example.batch.simple.infrastructure.employee.store.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Test
    public void findAll() {
        List<Employee> list = employeeRepository.findAll();
        assertTrue(list.size() > 0);
    }

    @Test
    public void findByName() {
        List<Employee> list = employeeRepository.findByName("홍우람");
        assertFalse(list.isEmpty());
    }
}