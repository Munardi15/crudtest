package com.example.crudtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crudtest.entity.Salary;
import com.example.crudtest.entity.SalaryId;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, SalaryId> {
}
