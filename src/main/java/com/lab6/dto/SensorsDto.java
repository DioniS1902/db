package com.lab6.dto;

import com.lab6.models.Sensors;
import com.lab6.models.Transport;

public class SensorsDto {
    private Sensors sensors;

    public SensorsDto(Sensors sensors) {
        this.sensors = sensors;
    }

    public int getId() {
        return sensors.getId();
    }

    public String getDateTime() {
        return sensors.getDateTime();
    }

    public Transport getTransportId() {
        return sensors.getTransportId();
    }
}
