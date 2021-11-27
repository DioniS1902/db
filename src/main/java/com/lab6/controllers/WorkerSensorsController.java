package com.lab6.controllers;

import com.lab6.dto.WorkerSensorsDto;
import com.lab6.exceptions.CareerNotFoundException;
import com.lab6.models.WorkerSensors;
import com.lab6.service.WorkerSensorsService;
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
@RequestMapping(path = "/workerSensors")
public class WorkerSensorsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkerSensorsController.class);

    @Autowired
    private WorkerSensorsService workerSensorsService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<WorkerSensorsDto> getWorkerSensors(@PathVariable(name = "id") Integer id) {
        if (workerSensorsService.getWorkerSensorsId(id) == null) {
            LOGGER.info("Can't update WorkerSensors with non-existing id" + id);
            throw new CareerNotFoundException("WorkerSensors with id: " + id + " not found");
        }
        LOGGER.info("Successfully gave an object:" + id);
        WorkerSensors WorkerSensors = workerSensorsService.getWorkerSensorsId(id);
        return new ResponseEntity<WorkerSensorsDto>(new WorkerSensorsDto(WorkerSensors), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<WorkerSensorsDto>> getWorkerSensors() {
        LOGGER.info("Successfully gave an objects");
        List<WorkerSensors> cities = workerSensorsService.getWorkerSensors();
        List<WorkerSensorsDto> citiesDto = new ArrayList<>();
        for (WorkerSensors WorkerSensors:cities) {
            WorkerSensorsDto WorkerSensorsDto = new WorkerSensorsDto(WorkerSensors);
            citiesDto.add(WorkerSensorsDto);
        }
        return new ResponseEntity<List<WorkerSensorsDto>>(citiesDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WorkerSensors> createWorkerSensors(@Valid @RequestBody WorkerSensors WorkerSensors) {
        LOGGER.info("Success added WorkerSensors");
        return new ResponseEntity<WorkerSensors>(workerSensorsService.addWorkerSensors(WorkerSensors), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkerSensorsDto> updateWorkerSensors(@PathVariable("id")final int id, @Valid @RequestBody final WorkerSensors WorkerSensors) {
        if (workerSensorsService.getWorkerSensorsId(id) == null) {
            LOGGER.info("Can't update WorkerSensors without id - null value was passed instead of it");
            throw new CareerNotFoundException("WorkerSensors with id: " + id + " not found");
        }
        LOGGER.info("Updated an WorkerSensors with id: " + id);
        WorkerSensors.setId(id);
        workerSensorsService.updateWorkerSensors(WorkerSensors);
        return new ResponseEntity<WorkerSensorsDto>(new WorkerSensorsDto(WorkerSensors), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<WorkerSensors> deleteWorkerSensors(@PathVariable("id") Integer id) {
        if (workerSensorsService.getWorkerSensorsId(id) == null) {
            LOGGER.info("Can't delete WorkerSensors ");
            throw new CareerNotFoundException("WorkerSensors with id: " + id + " not found");
        }
        LOGGER.info("Successfully deleted WorkerSensors with id: " +id);
        workerSensorsService.deleteWorkerSensorsById(id);
        return ResponseEntity.noContent().build();
    }
}
