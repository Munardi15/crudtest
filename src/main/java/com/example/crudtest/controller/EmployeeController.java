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

import com.example.crudtest.entity.Employee;
import com.example.crudtest.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{empNo}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int empNo) {
        Optional<Employee> employee = employeeService.getEmployeeById(empNo);
        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("/{empNo}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int empNo, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(empNo, employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{empNo}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int empNo) {
        employeeService.deleteEmployee(empNo);
        return ResponseEntity.noContent().build();
    }
}
