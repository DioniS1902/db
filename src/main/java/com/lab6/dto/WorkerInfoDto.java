package com.lab6.dto;

import com.lab6.models.Worker;
import com.lab6.models.WorkerInfo;

import java.sql.Date;

public class WorkerInfoDto {
    private WorkerInfo workerInfo;

    public int getId() {
        return workerInfo.getId();
    }

    public WorkerInfoDto(WorkerInfo workerInfo) {
        this.workerInfo = workerInfo;
    }

    public String getFirstName() {
        return workerInfo.getFirstName();
    }

    public String getLastName() {
        return workerInfo.getLastName();
    }

    public Date getBirhday() {
        return workerInfo.getBirhday();
    }

    public Worker getWorkerId() {
        return workerInfo.getWorkerId();
    }
}
