package com.example.crudtest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudtest.entity.Employee;
import com.example.crudtest.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Integer empNo) {
        return employeeRepository.findById(empNo);
    }

    public Employee updateEmployee(Integer empNo, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(empNo).orElseThrow();
        employee.setBirthDate(employeeDetails.getBirthDate());
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setGender(employeeDetails.getGender());
        employee.setHireDate(employeeDetails.getHireDate());
        employee.setDepartment(employeeDetails.getDepartment());
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer empNo) {
        Employee employee = employeeRepository.findById(empNo).orElseThrow();
        employeeRepository.delete(employee);
    }
}
