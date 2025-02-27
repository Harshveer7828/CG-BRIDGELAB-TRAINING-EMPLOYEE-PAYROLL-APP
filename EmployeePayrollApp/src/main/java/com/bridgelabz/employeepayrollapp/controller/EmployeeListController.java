package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.services.EmployeServiceAsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/list")
public class EmployeeListController {
    @Autowired
    private EmployeServiceAsList employeServiceAsList;

    @GetMapping
    public String home(){
        return "Welcome to the home";
    }

    // GET request to get employee by id
    @GetMapping("/get/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeServiceAsList.getEmployeeById(id);
    }

    // POST request to add the employee in the database
    @PostMapping("/add")
    public boolean addEmployee(@RequestBody Employee newEmployee){
        return employeServiceAsList.addEmployee(newEmployee);
    }

    // GET request to get all the employee in the database
    @GetMapping("/get/employees")
    public List<Employee> getAllEmployees(){
        return employeServiceAsList.getAllEmployee();
    }

    // GET request to delete the employee from the database
    @GetMapping("/delete/{id}")
    public boolean deleteEmployee(@PathVariable Long id){
        return employeServiceAsList.deleteEmployee(id);
    }

    // Get request to update the value of the employee
    @GetMapping("/update/{id}")
    public Employee updateEmployeeDetails(@PathVariable Long id,@RequestBody Employee updatedEmployee){

        return employeServiceAsList.updateEmployee(id,updatedEmployee);
    }






}
