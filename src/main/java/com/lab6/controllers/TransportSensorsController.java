package com.lab6.controllers;

import com.lab6.dto.TransportSensorsDto;
import com.lab6.exceptions.CareerNotFoundException;
import com.lab6.models.TransportSensors;
import com.lab6.service.TransportSensorsService;
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
@RequestMapping(path = "/transportSensors")
public class TransportSensorsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransportSensorsController.class);

    @Autowired
    private TransportSensorsService transportSensorsService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<TransportSensorsDto> getTransportSensors(@PathVariable(name = "id") Integer id) {
        if (transportSensorsService.getTransportSensorsId(id) == null) {
            LOGGER.info("Can't update TransportSensors with non-existing id" + id);
            throw new CareerNotFoundException("TransportSensors with id: " + id + " not found");
        }
        LOGGER.info("Successfully gave an object:" + id);
        TransportSensors TransportSensors = transportSensorsService.getTransportSensorsId(id);
        return new ResponseEntity<TransportSensorsDto>(new TransportSensorsDto(TransportSensors), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TransportSensorsDto>> getTransportSensors() {
        LOGGER.info("Successfully gave an objects");
        List<TransportSensors> cities = transportSensorsService.getTransportSensors();
        List<TransportSensorsDto> citiesDto = new ArrayList<>();
        for (TransportSensors TransportSensors:cities) {
            TransportSensorsDto TransportSensorsDto = new TransportSensorsDto(TransportSensors);
            citiesDto.add(TransportSensorsDto);
        }
        return new ResponseEntity<List<TransportSensorsDto>>(citiesDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TransportSensors> createTransportSensors(@Valid @RequestBody TransportSensors TransportSensors) {
        LOGGER.info("Success added TransportSensors");
        return new ResponseEntity<TransportSensors>(transportSensorsService.addTransportSensors(TransportSensors), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransportSensorsDto> updateTransportSensors(@PathVariable("id")final int id, @Valid @RequestBody final TransportSensors TransportSensors) {
        if (transportSensorsService.getTransportSensorsId(id) == null) {
            LOGGER.info("Can't update TransportSensors without id - null value was passed instead of it");
            throw new CareerNotFoundException("TransportSensors with id: " + id + " not found");
        }
        LOGGER.info("Updated an TransportSensors with id: " + id);
        TransportSensors.setId(id);
        transportSensorsService.updateTransportSensors(TransportSensors);
        return new ResponseEntity<TransportSensorsDto>(new TransportSensorsDto(TransportSensors), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<TransportSensors> deleteTransportSensors(@PathVariable("id") Integer id) {
        if (transportSensorsService.getTransportSensorsId(id) == null) {
            LOGGER.info("Can't delete TransportSensors ");
            throw new CareerNotFoundException("TransportSensors with id: " + id + " not found");
        }
        LOGGER.info("Successfully deleted TransportSensors with id: " +id);
        transportSensorsService.deleteTransportSensorsById(id);
        return ResponseEntity.noContent().build();
    }
}
