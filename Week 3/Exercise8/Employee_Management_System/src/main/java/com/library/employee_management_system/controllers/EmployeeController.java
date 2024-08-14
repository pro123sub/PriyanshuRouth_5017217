package com.library.employee_management_system.controllers;

import com.library.employee_management_system.model.Employee;
import com.library.employee_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
@Service
@RestController
@RequestMapping("/employees")
public class EmployeeController
{
    @Autowired
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }
    @GetMapping
    public Page<Employee> getAllEmployees(Pageable pageable)
    {
        return (Page<Employee>) employeeService.getAllEmployees(pageable);
    }
    @GetMapping("/sorted")
    public Page<Employee> getAllEmployeesSorted(@RequestParam int page, @RequestParam int size, @RequestParam String sortBy)
    {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return (Page<Employee>) employeeService.getAllEmployees(pageable);
    }

}
