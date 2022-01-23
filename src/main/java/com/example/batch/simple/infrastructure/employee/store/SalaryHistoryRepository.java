package com.example.batch.simple.infrastructure.employee.store;

import com.example.batch.simple.domain.employee.entity.SalaryHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryHistoryRepository extends JpaRepository<SalaryHistory, Integer> {
}
