package com.library.employee_management_system.service;

import com.library.employee_management_system.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    Department saveDepartment(Department department);
    void deleteDepartment(Long id);
}