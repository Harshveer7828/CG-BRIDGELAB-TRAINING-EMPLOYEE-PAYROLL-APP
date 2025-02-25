package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @GetMapping
    public String homepage() {
        return "WELCOME TO THE EMPLOYEE PAYROLL APP";
    }


}
