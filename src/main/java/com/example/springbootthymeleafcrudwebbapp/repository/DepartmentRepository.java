package com.example.springbootthymeleafcrudwebbapp.repository;

import com.example.springbootthymeleafcrudwebbapp.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query(nativeQuery = true, value = "select * from demo.department d where d.name like %:keyword%")
    List<Department> findByKeyword(@Param("keyword") String keyword);
}

