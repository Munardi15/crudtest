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
@Table(name = "titles")
@IdClass(TitleId.class)
public class Title {
    @Id
    @Column(name = "emp_no")
    private int empNo;

    @Id
    @Column(name = "dept_no")
    private String deptNo;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "from_date", nullable = false)
    private Date fromDate;

    @Column(name = "to_date")
    private Date toDate;
}
