package com.lab6.controllers;

import com.lab6.dto.PositionDto;
import com.lab6.exceptions.CareerNotFoundException;
import com.lab6.models.Position;
import com.lab6.service.PositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/position")
public class PositionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PositionController.class);

    @Autowired
    private PositionService positionService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<PositionDto> getPosition(@PathVariable(name = "id") Integer id) {
        if (positionService.getPositionId(id) == null) {
            LOGGER.info("Can't update Position with non-existing id" + id);
            throw new CareerNotFoundException("Position with id: " + id + " not found");
        }
        LOGGER.info("Successfully gave an object:" + id);
        Position Position = positionService.getPositionId(id);
        return new ResponseEntity<PositionDto>(new PositionDto(Position), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PositionDto>> getPosition() {
        LOGGER.info("Successfully gave an objects");
        List<Position> cities = positionService.getPosition();
        List<PositionDto> citiesDto = new ArrayList<>();
        for (Position Position:cities) {
            PositionDto PositionDto = new PositionDto(Position);
            citiesDto.add(PositionDto);
        }
        return new ResponseEntity<List<PositionDto>>(citiesDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Position> createPosition(@Valid @RequestBody Position Position) {
        LOGGER.info("Success added Position");
        return new ResponseEntity<Position>(positionService.addPosition(Position), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PositionDto> updatePosition(@PathVariable("id")final int id, @Valid @RequestBody final Position Position) {
        if (positionService.getPositionId(id) == null) {
            LOGGER.info("Can't update Position without id - null value was passed instead of it");
            throw new CareerNotFoundException("Position with id: " + id + " not found");
        }
        LOGGER.info("Updated an Position with id: " + id);
        Position.setId(id);
        positionService.updatePosition(Position);
        return new ResponseEntity<PositionDto>(new PositionDto(Position), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Position> deletePosition(@PathVariable("id") Integer id) {
        if (positionService.getPositionId(id) == null) {
            LOGGER.info("Can't delete Position ");
            throw new CareerNotFoundException("Position with id: " + id + " not found");
        }
        LOGGER.info("Successfully deleted Position with id: " +id);
        positionService.deletePositionById(id);
        return ResponseEntity.noContent().build();
    }
}
