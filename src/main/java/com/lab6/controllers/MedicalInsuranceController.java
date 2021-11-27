package com.lab6.controllers;

import com.lab6.dto.MedicalInsuranceDto;
import com.lab6.exceptions.CareerNotFoundException;
import com.lab6.exceptions.CareerNotFoundException;
import com.lab6.models.MedicalInsurance;
import com.lab6.service.MedicalInsuranceService;
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
@RequestMapping(path = "/medicalInsurance")
public class MedicalInsuranceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MedicalInsuranceController.class);

    @Autowired
    private MedicalInsuranceService medicalInsuranceService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<MedicalInsuranceDto> getMedicalInsurance(@PathVariable(name = "id") Integer id) {
        if (medicalInsuranceService.getMedicalInsuranceId(id) == null) {
            LOGGER.info("Can't update MedicalInsurance with non-existing id" + id);
            throw new CareerNotFoundException("MedicalInsurance with id: " + id + " not found");
        }
        LOGGER.info("Successfully gave an object:" + id);
        MedicalInsurance MedicalInsurance = medicalInsuranceService.getMedicalInsuranceId(id);
        return new ResponseEntity<MedicalInsuranceDto>(new MedicalInsuranceDto(MedicalInsurance), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MedicalInsuranceDto>> getMedicalInsurance() {
        LOGGER.info("Successfully gave an objects");
        List<MedicalInsurance> cities = medicalInsuranceService.getMedicalInsurance();
        List<MedicalInsuranceDto> citiesDto = new ArrayList<>();
        for (MedicalInsurance MedicalInsurance:cities) {
            MedicalInsuranceDto MedicalInsuranceDto = new MedicalInsuranceDto(MedicalInsurance);
            citiesDto.add(MedicalInsuranceDto);
        }
        return new ResponseEntity<List<MedicalInsuranceDto>>(citiesDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MedicalInsurance> createMedicalInsurance(@Valid @RequestBody MedicalInsurance medicalInsurance) {
        LOGGER.info("Success added medicalInsurance");
        return new ResponseEntity<MedicalInsurance>(medicalInsuranceService.addMedicalInsurance(medicalInsurance), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MedicalInsuranceDto> updateMedicalInsurance(@PathVariable("id")final int id, @Valid @RequestBody final MedicalInsurance medicalInsurance) {
        if (medicalInsuranceService.getMedicalInsuranceId(id) == null) {
            LOGGER.info("Can't update medicalInsurance without id - null value was passed instead of it");
            throw new CareerNotFoundException("medicalInsurance with id: " + id + " not found");
        }
        LOGGER.info("Updated an medicalInsurance with id: " + id);
        medicalInsurance.setId(id);
        medicalInsuranceService.updateMedicalInsurance(medicalInsurance);
        return new ResponseEntity<MedicalInsuranceDto>(new MedicalInsuranceDto(medicalInsurance), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<MedicalInsurance> deleteMedicalInsurance(@PathVariable("id") Integer id) {
        if (medicalInsuranceService.getMedicalInsuranceId(id) == null) {
            LOGGER.info("Can't delete MedicalInsurance ");
            throw new CareerNotFoundException("MedicalInsurance with id: " + id + " not found");
        }
        LOGGER.info("Successfully deleted MedicalInsurance with id: " +id);
        medicalInsuranceService.deleteMedicalInsuranceById(id);
        return ResponseEntity.noContent().build();
    }
}
