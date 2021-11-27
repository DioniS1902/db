package com.lab6.service;

import com.lab6.models.Worker;
import com.lab6.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class WorkerService {

    @Autowired
    public WorkerRepository workerRepository;

    public Worker addWorker(final Worker worker) {
        return workerRepository.save(worker);
    }

    public Worker updateWorker(final Worker worker) {
        return workerRepository.save(worker);
    }

    public List<Worker> getWorker() {
        return workerRepository.findAll();
    }

    public Worker getWorkerId(final Integer id) {
        return workerRepository.findById(id).orElse(null);
    }

    public void deleteWorkerById(Integer id){
        workerRepository.deleteById(id);
    }
}
