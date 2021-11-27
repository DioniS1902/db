package com.lab6.controllers;

import com.lab6.dto.WorkerInfoDto;
import com.lab6.exceptions.CareerNotFoundException;
import com.lab6.models.WorkerInfo;
import com.lab6.service.WorkerInfoService;
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
@RequestMapping(path = "/workerInfo")
public class WorkerInfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkerInfoController.class);

    @Autowired
    private WorkerInfoService workerInfoService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<WorkerInfoDto> getWorkerInfo(@PathVariable(name = "id") Integer id) {
        if (workerInfoService.getWorkerInfoId(id) == null) {
            LOGGER.info("Can't update WorkerInfo with non-existing id" + id);
            throw new CareerNotFoundException("WorkerInfo with id: " + id + " not found");
        }
        LOGGER.info("Successfully gave an object:" + id);
        WorkerInfo WorkerInfo = workerInfoService.getWorkerInfoId(id);
        return new ResponseEntity<WorkerInfoDto>(new WorkerInfoDto(WorkerInfo), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<WorkerInfoDto>> getWorkerInfo() {
        LOGGER.info("Successfully gave an objects");
        List<WorkerInfo> cities = workerInfoService.getWorkerInfo();
        List<WorkerInfoDto> citiesDto = new ArrayList<>();
        for (WorkerInfo WorkerInfo:cities) {
            WorkerInfoDto WorkerInfoDto = new WorkerInfoDto(WorkerInfo);
            citiesDto.add(WorkerInfoDto);
        }
        return new ResponseEntity<List<WorkerInfoDto>>(citiesDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WorkerInfo> createWorkerInfo(@Valid @RequestBody WorkerInfo WorkerInfo) {
        LOGGER.info("Success added WorkerInfo");
        return new ResponseEntity<WorkerInfo>(workerInfoService.addWorkerInfo(WorkerInfo), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorkerInfoDto> updateWorkerInfo(@PathVariable("id")final int id, @Valid @RequestBody final WorkerInfo WorkerInfo) {
        if (workerInfoService.getWorkerInfoId(id) == null) {
            LOGGER.info("Can't update WorkerInfo without id - null value was passed instead of it");
            throw new CareerNotFoundException("WorkerInfo with id: " + id + " not found");
        }
        LOGGER.info("Updated an WorkerInfo with id: " + id);
        WorkerInfo.setId(id);
        workerInfoService.updateWorkerInfo(WorkerInfo);
        return new ResponseEntity<WorkerInfoDto>(new WorkerInfoDto(WorkerInfo), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<WorkerInfo> deleteWorkerInfo(@PathVariable("id") Integer id) {
        if (workerInfoService.getWorkerInfoId(id) == null) {
            LOGGER.info("Can't delete WorkerInfo ");
            throw new CareerNotFoundException("WorkerInfo with id: " + id + " not found");
        }
        LOGGER.info("Successfully deleted WorkerInfo with id: " +id);
        workerInfoService.deleteWorkerInfoById(id);
        return ResponseEntity.noContent().build();
    }
}
