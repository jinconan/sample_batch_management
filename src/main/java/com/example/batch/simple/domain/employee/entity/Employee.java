package com.example.batch.simple.domain.employee.entity;

import com.example.batch.simple.domain.common.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Optional;

@Entity
@ToString
@Getter
public class Employee extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer money;

    @ManyToOne
    @JoinColumn(name = "RANK_ID")
    private Rank rank;

    @ManyToOne
    @JoinColumn(name = "DEPT_ID")
    private Department department;

    public Integer getSalary() {
        return this.rank.getSalary();
    }

    public void giveSalary() {
        Integer salary = this.rank.getSalary();
        this.money = this.money + salary;
    }

    public void giveInsentive(Integer salary) {
        salary = Optional.ofNullable(salary).orElse(0);
        this.money = this.money + salary;
    }
}
