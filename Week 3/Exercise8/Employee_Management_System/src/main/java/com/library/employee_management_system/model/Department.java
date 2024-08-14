package com.library.employee_management_system.model;

import com.library.employee_management_system.model.Employee;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
