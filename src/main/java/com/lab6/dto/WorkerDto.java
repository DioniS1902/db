package com.lab6.dto;

import com.lab6.models.Transport;
import com.lab6.models.Worker;

public class WorkerDto {
    private Worker worker;

    public WorkerDto(Worker worker) {
        this.worker = worker;
    }

    public int getId() {
        return worker.getId();
    }

    public Transport getTransportId() {
        return worker.getTransportId();
    }
}
