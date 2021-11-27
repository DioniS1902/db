package com.lab6.controllers;

import com.lab6.dto.SensorsDto;
import com.lab6.exceptions.CareerNotFoundException;
import com.lab6.models.Sensors;
import com.lab6.service.SensorsService;
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
@RequestMapping(path = "/sensors")
public class SensorsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SensorsController.class);

    @Autowired
    private SensorsService sensorsService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<SensorsDto> getSensors(@PathVariable(name = "id") Integer id) {
        if (sensorsService.getSensorsId(id) == null) {
            LOGGER.info("Can't update Sensors with non-existing id" + id);
            throw new CareerNotFoundException("Sensors with id: " + id + " not found");
        }
        LOGGER.info("Successfully gave an object:" + id);
        Sensors Sensors = sensorsService.getSensorsId(id);
        return new ResponseEntity<SensorsDto>(new SensorsDto(Sensors), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SensorsDto>> getSensors() {
        LOGGER.info("Successfully gave an objects");
        List<Sensors> cities = sensorsService.getSensors();
        List<SensorsDto> citiesDto = new ArrayList<>();
        for (Sensors Sensors:cities) {
            SensorsDto SensorsDto = new SensorsDto(Sensors);
            citiesDto.add(SensorsDto);
        }
        return new ResponseEntity<List<SensorsDto>>(citiesDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Sensors> createSensors(@Valid @RequestBody Sensors Sensors) {
        LOGGER.info("Success added Sensors");
        return new ResponseEntity<Sensors>(sensorsService.addSensors(Sensors), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SensorsDto> updateSensors(@PathVariable("id")final int id, @Valid @RequestBody final Sensors Sensors) {
        if (sensorsService.getSensorsId(id) == null) {
            LOGGER.info("Can't update Sensors without id - null value was passed instead of it");
            throw new CareerNotFoundException("Sensors with id: " + id + " not found");
        }
        LOGGER.info("Updated an Sensors with id: " + id);
        Sensors.setId(id);
        sensorsService.updateSensors(Sensors);
        return new ResponseEntity<SensorsDto>(new SensorsDto(Sensors), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Sensors> deleteSensors(@PathVariable("id") Integer id) {
        if (sensorsService.getSensorsId(id) == null) {
            LOGGER.info("Can't delete Sensors ");
            throw new CareerNotFoundException("Sensors with id: " + id + " not found");
        }
        LOGGER.info("Successfully deleted Sensors with id: " +id);
        sensorsService.deleteSensorsById(id);
        return ResponseEntity.noContent().build();
    }
}
