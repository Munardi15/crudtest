package com.example.crudtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crudtest.entity.DeptEmp;
import com.example.crudtest.entity.DeptEmpId;

@Repository
public interface DeptEmpRepository extends JpaRepository<DeptEmp, DeptEmpId> {
}
