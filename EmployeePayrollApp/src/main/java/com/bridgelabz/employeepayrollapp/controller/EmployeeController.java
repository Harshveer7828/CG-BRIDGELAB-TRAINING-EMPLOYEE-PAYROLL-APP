package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.services.EmployeServices;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j // using for logger
@Validated
@RestController
public class EmployeeController {

    private final EmployeServices employeServices;

    public EmployeeController(EmployeServices employeServices) {
        this.employeServices = employeServices;
    }

    @GetMapping
    public String homepage() {
        log.info("App started at / route");
        return "WELCOME TO THE EMPLOYEE PAYROLL APP";
    }

    @GetMapping("/employees")
    public List<Employee> displayAllEmployee() {
        log.info("Fetching all employees at /employee route");
        List<Employee> employees = employeServices.findAllEmploy();
        log.debug("Total employees found:- {}", employees.size());
        return employees;
    }

    @GetMapping("/find/{id}")
    public Optional<Employee> findEmployeeById(@PathVariable Long id) {
        log.info("Fetching the employee with ID:- {}", id);
        Optional<Employee> employee = employeServices.findById(id);
        if (employee.isPresent()) {
            log.info("Employee found with the ID:- {}", id);
            return employee;
        } else {
            log.warn("Employee with {} not found", id);
        }
        return employee;
    }

    @GetMapping("/update/{id}")
    public Employee updateEmployee(@Valid @PathVariable Long id, @RequestBody Employee updateEmployee) {
        log.info("Updating employee with ID: {}", id);
        Employee employee = employeServices.updateEmployee(id, updateEmployee);
        log.debug("New employee successfully added with the ID:- {}", employee);
        return employee;
    }

    @PostMapping("/add")
    public Employee addEmployee(@Valid @RequestBody Employee employee) {
        log.info("Adding new employee:- {}",employee);
        Employee newEmployee = employeServices.addNewEmploye(employee);
        log.debug("New employee created successfully:- {}",newEmployee);
        return newEmployee;
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        log.info("Attempting to delete employee with ID:- {}", id);
        if (employeServices.deleteEmployee(id)) {
            log.info("Employee with ID {} deleted successfully", id);
            return "Employee deleted successfully! 🙃";
        }
        log.error("Failed to delete employee with ID:- {}", id);
        return "Something went wrong!";
    }

}
