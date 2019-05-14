package com.scheduler.employees.employee;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    List<Employee> getAllEmployees() {
       List<Employee> employees = new ArrayList<>();
       employeeRepository.findAll().forEach(employees::add);
       return employees;
    }

    Employee getEmployee(int employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    void updateEmployee(Employee employee) {
        if (employeeRepository.findById(employee.getId()).isPresent()) {
            employeeRepository.save(employee);
        }
    }

    void removeEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
