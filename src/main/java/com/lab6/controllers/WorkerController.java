package com.lab6.controllers;

import com.lab6.dto.WorkerDto;
import com.lab6.exceptions.CareerNotFoundException;
import com.lab6.models.Worker;
import com.lab6.service.WorkerService;
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
@RequestMapping(path = "/worker")
public class WorkerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkerController.class);

    @Autowired
    private WorkerService workerService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<WorkerDto> getWorker(@PathVariable(name = "id") Integer id) {
        if (workerService.getWorkerId(id) == null) {
            LOGGER.info("Can't update Worker with non-existing id" + id);
            throw new CareerNotFoundException("Worker with id: " + id + " not found");
        }
        LOGGER.info("Successfully gave an object:" + id);
        Worker Worker = workerService.getWorkerId(id);
        return new ResponseEntity<WorkerDto>(new WorkerDto(Worker), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<WorkerDto>> getWorker() {
        LOGGER.info("Successfully gave an objects");
        List<Worker> cities = workerService.getWorker();
        List<WorkerDto> citiesDto = new ArrayList<>();
        for (Worker Worker:cities) {
            WorkerDto WorkerDto = new WorkerDto(Worker);
            citiesDto.add(WorkerDto);
        }
        return new ResponseEntity<List<WorkerDto>>(citiesDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Worker> createWorker(@Valid @RequestBody Worker Worker) {
        LOGGER.info("Success added Worker");
        return new ResponseEntity<Worker>(workerService.addWorker(Worker), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkerDto> updateWorker(@PathVariable("id")final int id, @Valid @RequestBody final Worker Worker) {
        if (workerService.getWorkerId(id) == null) {
            LOGGER.info("Can't update Worker without id - null value was passed instead of it");
            throw new CareerNotFoundException("Worker with id: " + id + " not found");
        }
        LOGGER.info("Updated an Worker with id: " + id);
        Worker.setId(id);
        workerService.updateWorker(Worker);
        return new ResponseEntity<WorkerDto>(new WorkerDto(Worker), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Worker> deleteWorker(@PathVariable("id") Integer id) {
        if (workerService.getWorkerId(id) == null) {
            LOGGER.info("Can't delete Worker ");
            throw new CareerNotFoundException("Worker with id: " + id + " not found");
        }
        LOGGER.info("Successfully deleted Worker with id: " +id);
        workerService.deleteWorkerById(id);
        return ResponseEntity.noContent().build();
    }
}
