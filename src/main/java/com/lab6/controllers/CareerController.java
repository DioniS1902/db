package com.lab6.controllers;

import com.lab6.dto.CareerDto;
import com.lab6.exceptions.CareerNotFoundException;
import com.lab6.models.Career;
import com.lab6.service.CareerService;
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
@RequestMapping(path = "/career")
public class CareerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CareerController.class);

    @Autowired
    private CareerService careerService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<CareerDto> getCareer(@PathVariable(name = "id") Integer id) {
        if (careerService.getCareerId(id) == null) {
            LOGGER.info("Can't update Career with non-existing id" + id);
            throw new CareerNotFoundException("Career with id: " + id + " not found");
        }
        LOGGER.info("Successfully gave an object:" + id);
        Career Career = careerService.getCareerId(id);
        return new ResponseEntity<CareerDto>(new CareerDto(Career), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CareerDto>> getCareer() {
        LOGGER.info("Successfully gave an objects");
        List<Career> cities = careerService.getCareer();
        List<CareerDto> citiesDto = new ArrayList<>();
        for (Career Career:cities) {
            CareerDto CareerDto = new CareerDto(Career);
            citiesDto.add(CareerDto);
        }
        return new ResponseEntity<List<CareerDto>>(citiesDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Career> createCareer(@Valid @RequestBody Career career) {
        LOGGER.info("Success added Career");
        return new ResponseEntity<Career>(careerService.addCareer(career), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CareerDto> updateCareer(@PathVariable("id")final int id, @Valid @RequestBody final Career career) {
        if (careerService.getCareerId(id) == null) {
            LOGGER.info("Can't update Career without id - null value was passed instead of it");
            throw new CareerNotFoundException("Career with id: " + id + " not found");
        }
        LOGGER.info("Updated an Career with id: " + id);
        career.setId(id);
        careerService.updateCareer(career);
        return new ResponseEntity<CareerDto>(new CareerDto(career), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Career> deleteCareer(@PathVariable("id") Integer id) {
        if (careerService.getCareerId(id) == null) {
            LOGGER.info("Can't delete Career ");
            throw new CareerNotFoundException("Career with id: " + id + " not found");
        }
        LOGGER.info("Successfully deleted Career with id: " +id);
        careerService.deleteCareerById(id);
        return ResponseEntity.noContent().build();
    }
}
