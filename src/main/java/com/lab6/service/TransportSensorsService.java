package com.lab6.service;

import com.lab6.models.TransportSensors;
import com.lab6.repository.TransportSensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class TransportSensorsService {

    @Autowired
    public TransportSensorsRepository transportSensorsRepository;

    public TransportSensors addTransportSensors(final TransportSensors transportSensors) {
        return transportSensorsRepository.save(transportSensors);
    }

    public TransportSensors updateTransportSensors(final TransportSensors transportSensors) {
        return transportSensorsRepository.save(transportSensors);
    }

    public List<TransportSensors> getTransportSensors() {
        return transportSensorsRepository.findAll();
    }

    public TransportSensors getTransportSensorsId(final Integer id) {
        return transportSensorsRepository.findById(id).orElse(null);
    }

    public void deleteTransportSensorsById(Integer id){
        transportSensorsRepository.deleteById(id);
    }
}
