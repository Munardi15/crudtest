package com.example.crudtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crudtest.entity.DeptManager;
import com.example.crudtest.entity.DeptManagerId;

@Repository
public interface DeptManagerRepository extends JpaRepository<DeptManager, DeptManagerId> {
}