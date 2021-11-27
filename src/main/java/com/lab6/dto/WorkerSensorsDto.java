package com.lab6.dto;

import com.lab6.models.Sensors;
import com.lab6.models.WorkerSensors;

public class WorkerSensorsDto {
    private WorkerSensors workerSensors;

    public WorkerSensorsDto(WorkerSensors workerSensors) {
        this.workerSensors = workerSensors;
    }

    public int getId() {
        return workerSensors.getId();
    }

    public Double getTemperature() {
        return workerSensors.getTemperature();
    }

    public Double getPalpitation() {
        return workerSensors.getPalpitation();
    }

    public Sensors getSensorsId() {
        return workerSensors.getSensorsId();
    }
}
