package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeServices {

    @Autowired
    private EmployeeRepository employeeRepository;


    // Method to find the all employee
    public List<Employee> findAllEmploy(){
        return employeeRepository.findAll();
    }

    // Method to find the employee by ID
    public Optional<Employee> findById(Long id){
        return employeeRepository.findById(id);
    }

    // Method to add new employee in the database
    public Employee addNewEmploye(Employee employee){
        return employeeRepository.save(employee);
    }

    // Method to update the employee details
    public Employee updateEmployee(Long id,Employee updatedEmployee){
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException(("Employee not found")));

        if (updatedEmployee.getName() != null){
            existingEmployee.setName(updatedEmployee.getName());
        }

        if (updatedEmployee.getDepartment() != null){
            existingEmployee.setDepartment(updatedEmployee.getDepartment());
        }
        if (updatedEmployee.getSalary() != null ){
            existingEmployee.setSalary(updatedEmployee.getSalary());
        }

        return employeeRepository.save(existingEmployee);

    }

    // Method to delete the employee data
    public boolean deleteEmployee(Long id){
        if (employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
