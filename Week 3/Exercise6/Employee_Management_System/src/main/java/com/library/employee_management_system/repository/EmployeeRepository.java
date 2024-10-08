package com.library.employee_management_system.repository;

import com.library.employee_management_system.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee,Long>
{
    Page<Employee> findAll(Pageable pageable);
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findByEmail(@Param("email")String email);
}
