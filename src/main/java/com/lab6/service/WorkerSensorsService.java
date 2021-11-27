package com.lab6.service;

import com.lab6.models.WorkerSensors;
import com.lab6.repository.WorkerSensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class WorkerSensorsService {

    @Autowired
    public WorkerSensorsRepository WorkerSensorsRepository;

    public WorkerSensors addWorkerSensors(final WorkerSensors workerSensors) {
        return WorkerSensorsRepository.save(workerSensors);
    }

    public WorkerSensors updateWorkerSensors(final WorkerSensors workerSensors) {
        return WorkerSensorsRepository.save(workerSensors);
    }

    public List<WorkerSensors> getWorkerSensors() {
        return WorkerSensorsRepository.findAll();
    }

    public WorkerSensors getWorkerSensorsId(final Integer id) {
        return WorkerSensorsRepository.findById(id).orElse(null);
    }

    public void deleteWorkerSensorsById(Integer id){
        WorkerSensorsRepository.deleteById(id);
    }
}
