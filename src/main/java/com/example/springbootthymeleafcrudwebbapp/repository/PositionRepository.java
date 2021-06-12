package com.example.springbootthymeleafcrudwebbapp.repository;

import com.example.springbootthymeleafcrudwebbapp.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    @Query(nativeQuery = true, value = "select * from demo.position p where p.name like %:keyword%")
    List<Position> findByKeyword(@Param("keyword") String keyword);
}
