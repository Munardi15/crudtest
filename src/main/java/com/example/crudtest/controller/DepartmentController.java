package com.example.crudtest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudtest.entity.Department;
import com.example.crudtest.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department createdDepartment = departmentService.createDepartment(department);
        return new ResponseEntity<>(createdDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/{deptNo}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable String deptNo) {
        Optional<Department> department = departmentService.getDepartmentById(deptNo);
        if (department.isPresent()) {
            return ResponseEntity.ok(department.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @PutMapping("/{deptNo}")
    public ResponseEntity<Department> updateDepartment(@PathVariable String deptNo, @RequestBody Department department) {
        Department updatedDepartment = departmentService.updateDepartment(deptNo, department);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/{deptNo}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable String deptNo) {
        departmentService.deleteDepartment(deptNo);
        return ResponseEntity.noContent().build();
    }
}
