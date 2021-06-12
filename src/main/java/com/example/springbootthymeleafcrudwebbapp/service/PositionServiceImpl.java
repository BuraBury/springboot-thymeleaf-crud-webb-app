package com.example.springbootthymeleafcrudwebbapp.service;

import com.example.springbootthymeleafcrudwebbapp.model.Position;
import com.example.springbootthymeleafcrudwebbapp.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    @Autowired
    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }


    @Override
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    @Override
    public void savePosition(Position position) {
        positionRepository.save(position);
    }

    @Override
    public Position getPositionById(long id) {
        Optional<Position> optionalPosition = positionRepository.findById(id);
        Position position = null;
        if (optionalPosition.isPresent()) {
            position = optionalPosition.get();
        } else {
            throw new RuntimeException("Position not found for id: " + id);
        }

        return position;
    }

    @Override
    public List<Position> findByKeyword(String keyword) {
        return positionRepository.findByKeyword(keyword);
    }

    @Override
    public void deletePositionById(long id) {
        this.positionRepository.deleteById(id);
    }
}
