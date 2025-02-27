package com.bridgelabz.employeepayrollapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class  Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid, not match the regex")
    private String name;

    @DecimalMin(message = "Salary should be more than 500", value = "500")
    private Double salary;

    @NotNull(message = "Department cannot be null")
    private String department;

    public Employee() {
    }

    public Employee(String name, String department, Double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }


}
