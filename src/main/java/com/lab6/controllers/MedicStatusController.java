package com.lab6.controllers;

import com.lab6.dto.MedicStatusDto;
import com.lab6.exceptions.CareerNotFoundException;
import com.lab6.models.MedicStatus;
import com.lab6.service.MedicStatusService;
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
@RequestMapping(path = "/medicStatus")
public class MedicStatusController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MedicStatusController.class);

    @Autowired
    private MedicStatusService medicStatusService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<MedicStatusDto> getMedicStatus(@PathVariable(name = "id") Integer id) {
        if (medicStatusService.getMedicStatusId(id) == null) {
            LOGGER.info("Can't update MedicStatus with non-existing id" + id);
            throw new CareerNotFoundException("MedicStatus with id: " + id + " not found");
        }
        LOGGER.info("Successfully gave an object:" + id);
        MedicStatus MedicStatus = medicStatusService.getMedicStatusId(id);
        return new ResponseEntity<MedicStatusDto>(new MedicStatusDto(MedicStatus), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MedicStatusDto>> getMedicStatus() {
        LOGGER.info("Successfully gave an objects");
        List<MedicStatus> cities = medicStatusService.getMedicStatus();
        List<MedicStatusDto> citiesDto = new ArrayList<>();
        for (MedicStatus MedicStatus:cities) {
            MedicStatusDto MedicStatusDto = new MedicStatusDto(MedicStatus);
            citiesDto.add(MedicStatusDto);
        }
        return new ResponseEntity<List<MedicStatusDto>>(citiesDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MedicStatus> createMedicStatus(@Valid @RequestBody MedicStatus MedicStatus) {
        LOGGER.info("Success added MedicStatus");
        return new ResponseEntity<MedicStatus>(medicStatusService.addMedicStatus(MedicStatus), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MedicStatusDto> updateMedicStatus(@PathVariable("id")final int id, @Valid @RequestBody final MedicStatus MedicStatus) {
        if (medicStatusService.getMedicStatusId(id) == null) {
            LOGGER.info("Can't update MedicStatus without id - null value was passed instead of it");
            throw new CareerNotFoundException("MedicStatus with id: " + id + " not found");
        }
        LOGGER.info("Updated an MedicStatus with id: " + id);
        MedicStatus.setId(id);
        medicStatusService.updateMedicStatus(MedicStatus);
        return new ResponseEntity<MedicStatusDto>(new MedicStatusDto(MedicStatus), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<MedicStatus> deleteMedicStatus(@PathVariable("id") Integer id) {
        if (medicStatusService.getMedicStatusId(id) == null) {
            LOGGER.info("Can't delete MedicStatus ");
            throw new CareerNotFoundException("MedicStatus with id: " + id + " not found");
        }
        LOGGER.info("Successfully deleted MedicStatus with id: " +id);
        medicStatusService.deleteMedicStatusById(id);
        return ResponseEntity.noContent().build();
    }
}
