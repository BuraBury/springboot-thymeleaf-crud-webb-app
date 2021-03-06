package com.example.springbootthymeleafcrudwebbapp.service;

import com.example.springbootthymeleafcrudwebbapp.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(long id);

    List<Employee> findByKeyword(String keyword);

    void deleteEmployeeById(long id);
}
