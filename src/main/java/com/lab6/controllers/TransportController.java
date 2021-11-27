package com.lab6.controllers;

import com.lab6.dto.TransportDto;
import com.lab6.exceptions.CareerNotFoundException;
import com.lab6.models.Transport;
import com.lab6.service.TransportService;
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
@RequestMapping(path = "/transport")
public class TransportController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransportController.class);

    @Autowired
    private TransportService transportService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<TransportDto> getTransport(@PathVariable(name = "id") Integer id) {
        if (transportService.getTransportId(id) == null) {
            LOGGER.info("Can't update Transport with non-existing id" + id);
            throw new CareerNotFoundException("Transport with id: " + id + " not found");
        }
        LOGGER.info("Successfully gave an object:" + id);
        Transport Transport = transportService.getTransportId(id);
        return new ResponseEntity<TransportDto>(new TransportDto(Transport), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TransportDto>> getTransport() {
        LOGGER.info("Successfully gave an objects");
        List<Transport> cities = transportService.getTransport();
        List<TransportDto> citiesDto = new ArrayList<>();
        for (Transport Transport:cities) {
            TransportDto TransportDto = new TransportDto(Transport);
            citiesDto.add(TransportDto);
        }
        return new ResponseEntity<List<TransportDto>>(citiesDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Transport> createTransport(@Valid @RequestBody Transport Transport) {
        LOGGER.info("Success added Transport");
        return new ResponseEntity<Transport>(transportService.addTransport(Transport), HttpStatus.OK);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransportDto> updateTransport(@PathVariable("id")final int id, @Valid @RequestBody final Transport Transport) {
        if (transportService.getTransportId(id) == null) {
            LOGGER.info("Can't update Transport without id - null value was passed instead of it");
            throw new CareerNotFoundException("Transport with id: " + id + " not found");
        }
        LOGGER.info("Updated an Transport with id: " + id);
        Transport.setId(id);
        transportService.updateTransport(Transport);
        return new ResponseEntity<TransportDto>(new TransportDto(Transport), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Transport> deleteTransport(@PathVariable("id") Integer id) {
        if (transportService.getTransportId(id) == null) {
            LOGGER.info("Can't delete Transport ");
            throw new CareerNotFoundException("Transport with id: " + id + " not found");
        }
        LOGGER.info("Successfully deleted Transport with id: " +id);
        transportService.deleteTransportById(id);
        return ResponseEntity.noContent().build();
    }
}
