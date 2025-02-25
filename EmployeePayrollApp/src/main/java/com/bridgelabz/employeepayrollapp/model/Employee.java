package com.bridgelabz.employeepayrollapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class  Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double salary;

    private String department;

    public Employee() {
    }

    public Employee(String name, String department, Double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }


}
