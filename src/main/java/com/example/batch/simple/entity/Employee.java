package com.example.batch.simple.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
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
}
