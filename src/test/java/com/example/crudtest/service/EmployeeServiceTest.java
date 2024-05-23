package com.example.crudtest.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.crudtest.entity.Employee;
import com.example.crudtest.repository.EmployeeRepository;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    public EmployeeServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateEmployee() {
        Employee employee = new Employee();
        employee.setEmpNo(1);
        employee.setFirstName("John");
        employee.setLastName("Doe");

        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee created = employeeService.createEmployee(employee);
        assertEquals(1, created.getEmpNo());
    }

    @Test
    void testGetEmployeeById() {
        Employee employee = new Employee();
        employee.setEmpNo(1);
        employee.setFirstName("John");
        employee.setLastName("Doe");

        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));

        Optional<Employee> found = employeeService.getEmployeeById(1);
        assertTrue(found.isPresent());
        assertEquals(1, found.get().getEmpNo());
    }

    @Test
    void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setEmpNo(1);
        employee.setFirstName("John");
        employee.setLastName("Doe");

        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        employee.setFirstName("Jane");
        Employee updated = employeeService.updateEmployee(1, employee);
        assertEquals("Jane", updated.getFirstName());
    }

    @Test
    void testDeleteEmployee() {
        Employee employee = new Employee();
        employee.setEmpNo(1);
        employee.setFirstName("John");
        employee.setLastName("Doe");

        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));
        doNothing().when(employeeRepository).delete(any(Employee.class));

        employeeService.deleteEmployee(1);
        verify(employeeRepository, times(1)).delete(employee);
    }
}
