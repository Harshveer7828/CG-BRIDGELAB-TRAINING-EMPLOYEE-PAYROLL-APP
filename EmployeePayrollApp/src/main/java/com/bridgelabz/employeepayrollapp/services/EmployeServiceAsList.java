package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeServiceAsList {
    List<Employee> employeeDatabase = new ArrayList<>();
    Long id = 1L;

    // Method to add the employee in the List
    public boolean addEmployee(Employee employee){
        employeeDatabase.add(employee);
        employee.setId(id++);
        return true;
    }

    // Get employee by id
    public Employee getEmployeeById(Long id){
        for (Employee employee : employeeDatabase) {
            if (employee.getId().equals(id)){
                return employee;
            }
        }
        return null;
    }

    // Get all the employeeList
    public List<Employee> getAllEmployee(){
        return employeeDatabase;
    }

    // Delete the employee from the database
    public boolean deleteEmployee(Long id){
        for (int i = 0; i < employeeDatabase.size(); i++) {
            if (employeeDatabase.get(i).getId().equals(id)){
                employeeDatabase.remove(i);
                return true;
            }
        }
        return false;
    }

    // Method to update the employee
    public Employee updateEmployee(Long id, Employee updatedEmployee){
        for (Employee employee : employeeDatabase) {
            if (employee.getId().equals(id)){
                employee.setName(updatedEmployee.getName());
                employee.setDepartment(updatedEmployee.getDepartment());
                employee.setSalary(updatedEmployee.getSalary());
                employee.setId(id);
                return employee;
            }
        }
        return null;
    }
}
