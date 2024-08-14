package com.library.employee_management_system.service;

import com.library.employee_management_system.model.Employee;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees(Pageable pageable);
    Employee getEmployeeById(Long id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(Long id);
}
