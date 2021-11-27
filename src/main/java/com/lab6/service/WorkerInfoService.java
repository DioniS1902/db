package com.lab6.service;

import com.lab6.models.WorkerInfo;
import com.lab6.repository.WorkerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class WorkerInfoService {

    @Autowired
    public WorkerInfoRepository workerInfoRepository;

    public WorkerInfo addWorkerInfo(final WorkerInfo workerInfo) {
        return workerInfoRepository.save(workerInfo);
    }

    public WorkerInfo updateWorkerInfo(final WorkerInfo workerInfo) {
        return workerInfoRepository.save(workerInfo);
    }

    public List<WorkerInfo> getWorkerInfo() {
        return workerInfoRepository.findAll();
    }

    public WorkerInfo getWorkerInfoId(final Integer id) {
        return workerInfoRepository.findById(id).orElse(null);
    }

    public void deleteWorkerInfoById(Integer id){
        workerInfoRepository.deleteById(id);
    }
}
