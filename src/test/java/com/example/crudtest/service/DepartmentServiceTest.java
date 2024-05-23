package com.example.crudtest.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.crudtest.entity.Department;
import com.example.crudtest.repository.DepartmentRepository;

public class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentService departmentService;

    public DepartmentServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateDepartment() {
        Department department = new Department();
        department.setDeptNo("D001");
        department.setDeptName("Engineering");
        department.setLocation("New York");

        when(departmentRepository.save(any(Department.class))).thenReturn(department);

        Department created = departmentService.createDepartment(department);
        assertEquals("D001", created.getDeptNo());
    }

    @Test
    void testGetDepartmentById() {
        Department department = new Department();
        department.setDeptNo("D001");
        department.setDeptName("Engineering");
        department.setLocation("New York");

        when(departmentRepository.findById("D001")).thenReturn(Optional.of(department));

        Optional<Department> found = departmentService.getDepartmentById("D001");
        assertTrue(found.isPresent());
        assertEquals("D001", found.get().getDeptNo());
    }

    @Test
    void testUpdateDepartment() {
        Department department = new Department();
        department.setDeptNo("D001");
        department.setDeptName("Engineering");
        department.setLocation("New York");

        when(departmentRepository.findById("D001")).thenReturn(Optional.of(department));
        when(departmentRepository.save(any(Department.class))).thenReturn(department);

        department.setDeptName("HR");
        Department updated = departmentService.updateDepartment("D001", department);
        assertEquals("HR", updated.getDeptName());
    }

    @Test
    void testDeleteDepartment() {
        Department department = new Department();
        department.setDeptNo("D001");
        department.setDeptName("Engineering");
        department.setLocation("New York");

        when(departmentRepository.findById("D001")).thenReturn(Optional.of(department));
        doNothing().when(departmentRepository).delete(any(Department.class));

        departmentService.deleteDepartment("D001");
        verify(departmentRepository, times(1)).delete(department);
    }
}
