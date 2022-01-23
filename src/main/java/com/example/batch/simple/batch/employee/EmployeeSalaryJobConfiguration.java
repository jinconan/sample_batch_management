package com.example.batch.simple.batch.employee;

import com.example.batch.simple.domain.employee.entity.Employee;
import com.example.batch.simple.domain.employee.entity.SalaryHistory;
import com.example.batch.simple.domain.employee.store.EmployeeStore;
import com.example.batch.simple.domain.employee.store.SalaryHistoryStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.AbstractPagingItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class EmployeeSalaryJobConfiguration {
    private static final String JOB_NAME = "giveSalaryWithHistoryJob";
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final EmployeeStore employeeStore;
    private final SalaryHistoryStore salaryHistoryStore;

    @Bean
    public Job giveSalaryWithHistoryJob() {
        return jobBuilderFactory.get(JOB_NAME)
                .flow(giveSalaryStep(null))
                .end()
                .build();
    }

    @Bean
    @JobScope
    public Step giveSalaryStep(
            @Value("#{jobParameters[regId]}") String regId
    ) {
        return stepBuilderFactory.get(JOB_NAME + "_giveSalaryStep")
                .<Employee, SalaryHistory>chunk(3)
                .reader(giveSalaryReader())
                .listener(giveSalaryReaderListener())
                .processor(giveSalaryProcessor())
                .writer(giveSalaryWriter())
                .build();
    }

    @Bean
    public ItemReadListener<Employee> giveSalaryReaderListener() {
        return new ItemReadListener<>() {
            @Override
            public void beforeRead() {
                log.error("[{}] beforeRead", JOB_NAME);
            }

            @Override
            public void afterRead(Employee item) {
                log.error("[{}] {}", JOB_NAME, item.getName());
            }

            @Override
            public void onReadError(Exception ex) {
                log.error("[{}] {}", JOB_NAME, ex.getMessage());

            }
        };
    }

    @Bean
    @StepScope
    public ItemReader<Employee> giveSalaryReader() {
        return new AbstractPagingItemReader<Employee>() {
            @Override
            protected void doReadPage() {
                this.results = employeeStore.getEmployees(getPage(), getPageSize());
            }

            @Override
            protected void doJumpToPage(int itemIndex) {}
        };
    }

    @Bean
    @StepScope
    public ItemProcessor<Employee, SalaryHistory> giveSalaryProcessor() {
        return (item) -> {
            SalaryHistory history = new SalaryHistory(item, null);
            history.createHistory(null);
            return history;
        };
    }

    @Bean
    @StepScope
    public ItemWriter<SalaryHistory> giveSalaryWriter() {
        return (item) -> {
            salaryHistoryStore.save((List<SalaryHistory>)item);
        };
    }

}
