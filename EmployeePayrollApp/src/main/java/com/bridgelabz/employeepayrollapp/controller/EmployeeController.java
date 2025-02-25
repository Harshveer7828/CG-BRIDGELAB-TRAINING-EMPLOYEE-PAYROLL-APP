package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.services.EmployeServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private final EmployeServices employeServices;

    public EmployeeController(EmployeServices employeServices) {
        this.employeServices = employeServices;
    }

    @GetMapping
    public String homepage() {
        return "WELCOME TO THE EMPLOYEE PAYROLL APP";
    }

    @GetMapping("/employees")
    public List<Employee> displayAllEmployee(){
        return employeServices.findAllEmploy();
    }

    @GetMapping("/find/{id}")
    public Optional<Employee> findEmployeeById(@PathVariable Long id ){
        return employeServices.findById(id);
    }

    @GetMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee updateEmployee){
        return employeServices.updateEmployee(id,updateEmployee);
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeServices.addNewEmploye(employee);
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if (employeServices.deleteEmployee(id)){
            return "Employee deleted successfully!🙃";
        }
        return "Something went wrong!";
    }

}
