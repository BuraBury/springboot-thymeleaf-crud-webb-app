package com.example.springbootthymeleafcrudwebbapp.repository;

import com.example.springbootthymeleafcrudwebbapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
