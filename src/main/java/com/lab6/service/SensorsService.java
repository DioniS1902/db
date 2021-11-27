package com.lab6.service;

import com.lab6.models.Sensors;
import com.lab6.repository.SensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class SensorsService {

    @Autowired
    public SensorsRepository sensorsRepository;

    public Sensors addSensors(final Sensors sensors) {
        return sensorsRepository.save(sensors);
    }

    public Sensors updateSensors(final Sensors sensors) {
        return sensorsRepository.save(sensors);
    }

    public List<Sensors> getSensors() {
        return sensorsRepository.findAll();
    }

    public Sensors getSensorsId(final Integer id) {
        return sensorsRepository.findById(id).orElse(null);
    }

    public void deleteSensorsById(Integer id){
        sensorsRepository.deleteById(id);
    }
}
