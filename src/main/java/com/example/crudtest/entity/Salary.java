package com.example.crudtest.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "salaries")
@IdClass(SalaryId.class)
public class Salary {
    @Id
    @Column(name = "emp_no")
    private int empNo;

    @Column(name = "dept_no", nullable = false)
    private String deptNo;

    @Column(name = "salary", nullable = false)
    private int salary;

    @Column(name = "from_date", nullable = false)
    private Date fromDate;

    @Column(name = "to_date")
    private Date toDate;
}
