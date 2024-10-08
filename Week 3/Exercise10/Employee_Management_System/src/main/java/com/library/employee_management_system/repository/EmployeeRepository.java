package com.library.employee_management_system.repository;

import com.library.employee_management_system.model.Employee;
import com.library.employee_management_system.projections.EmployeeProjection;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long>
{
    Page<Employee> findAll(Pageable pageable);
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findByEmail(@Param("email")String email);
    List<EmployeeProjection> findByDepartmentName(String departmentName);
    @Transactional
    @Modifying
    @Query("update Employee e set e.lastModifiedDate = ?1 where e.department.id = ?2")
    void updateEmployeeStatus(String status, Long departmentId);
}
