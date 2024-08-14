package com.library.employee_management_system.controllers;

import com.library.employee_management_system.model.Department;
import com.library.employee_management_system.model.Employee;
import com.library.employee_management_system.service.DepartmentService;
import com.library.employee_management_system.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service
public class DepartmentController
{
    EmployeeServiceImpl employeeService= new EmployeeServiceImpl();
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/sorted")
    public Page<Employee> getAllEmployeesSorted(@RequestParam int page, @RequestParam int size, @RequestParam String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return (Page<Employee>) employeeService.getAllEmployees(pageable);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails) {
        Department department = departmentService.getDepartmentById(id);
        department.setName(departmentDetails.getName());
        return departmentService.saveDepartment(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }
}
