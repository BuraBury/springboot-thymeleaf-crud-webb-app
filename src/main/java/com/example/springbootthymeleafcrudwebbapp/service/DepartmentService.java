package com.example.springbootthymeleafcrudwebbapp.service;

import com.example.springbootthymeleafcrudwebbapp.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();

    void saveDepartment(Department department);

    Department getDepartmentById(long id);

    List<Department> findByKeyword(String keyword);

    void deleteDepartmentById(long id);
}
