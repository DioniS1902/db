package com.lab6.dto;

import com.lab6.models.MedicStatus;
import com.lab6.models.Worker;

import java.sql.Date;

public class MedicStatusDto {
    private MedicStatus medicStatus;

    public MedicStatusDto(MedicStatus medicStatus) {
        this.medicStatus = medicStatus;
    }

    public int getId() {
        return medicStatus.getId();
    }

    public Double getTemperature() {
        return medicStatus.getTemperature();
    }

    public Worker getWorkerId() {
        return medicStatus.getWorkerId();
    }

    public Date getDate() {
        return medicStatus.getDate();
    }
}
