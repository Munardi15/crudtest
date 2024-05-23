package com.example.crudtest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudtest.entity.Department;
import com.example.crudtest.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(String deptNo) {
        return departmentRepository.findById(deptNo);
    }

    public Department updateDepartment(String deptNo, Department departmentDetails) {
        Department department = departmentRepository.findById(deptNo).orElseThrow();
        department.setDeptName(departmentDetails.getDeptName());
        return departmentRepository.save(department);
    }

    public void deleteDepartment(String deptNo) {
        Department department = departmentRepository.findById(deptNo).orElseThrow();
        departmentRepository.delete(department);
    }
}
