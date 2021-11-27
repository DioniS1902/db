package com.lab6.service;

import com.lab6.models.Position;
import com.lab6.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class PositionService {

    @Autowired
    public PositionRepository positionRepository;

    public Position addPosition(final Position position) {
        return positionRepository.save(position);
    }

    public Position updatePosition(final Position position) {
        return positionRepository.save(position);
    }

    public List<Position> getPosition() {
        return positionRepository.findAll();
    }

    public Position getPositionId(final Integer id) {
        return positionRepository.findById(id).orElse(null);
    }

    public void deletePositionById(Integer id){
        positionRepository.deleteById(id);
    }
}
