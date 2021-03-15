package com.example.springbootthymeleafcrudwebbapp.repository;

import com.example.springbootthymeleafcrudwebbapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query (nativeQuery=true, value = "select * from demo.employees e where e.first_name like %:keyword% or e.last_name like %:keyword% or e.department like %:keyword% or e.position like %:keyword% or e.email like %:keyword% or e.hire_date like %:keyword% or e.termination_date like %:keyword%")
    List<Employee> findByKeyword(@Param("keyword") String keyword);
}
