package com.example.springbootthymeleafcrudwebbapp.service;

import com.example.springbootthymeleafcrudwebbapp.model.Position;

import java.util.List;

public interface PositionService {
    List<Position> getAllPositions();

    void savePosition(Position position);

    Position getPositionById(long id);

    List<Position> findByKeyword(String keyword);

    void deletePositionById(long id);

}
