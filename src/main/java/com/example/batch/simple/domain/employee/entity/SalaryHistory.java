package com.example.batch.simple.domain.employee.entity;

import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Objects;

@Entity
@ToString
public class SalaryHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;

    private Integer money;

    @ManyToOne
    @JoinColumn(name = "EMP_ID")
    Employee employee;

    public SalaryHistory(Employee employee) {
        this(employee, null);
    }

    public SalaryHistory(Employee employee, String type) {
        this.employee = employee;
        this.type = Objects.isNull(type) ? "월급" : type;
    }

    public void createHistory(Integer money) {
        if ("월급".equals(type)) {
            employee.giveSalary();
        } else {
            employee.giveInsentive(money);
        }
    }
}
