package com.example.springbootthymeleafcrudwebbapp.service;

import com.example.springbootthymeleafcrudwebbapp.model.Department;
import com.example.springbootthymeleafcrudwebbapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

  private final DepartmentRepository departmentRepository;

  @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
      this.departmentRepository = departmentRepository;
  }


    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void saveDepartment(Department department) {
      departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(long id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        Department department = null;
        if(optionalDepartment.isPresent()) {
            department = optionalDepartment.get();
        } else {
            throw new RuntimeException("Department not found for id: " + id);
        }
        return department;
    }

    @Override
    public List<Department> findByKeyword(String keyword) {
        return departmentRepository.findByKeyword(keyword);
    }

    @Override
    public void deleteDepartmentById(long id) {
      this.departmentRepository.deleteById(id);
    }
}
