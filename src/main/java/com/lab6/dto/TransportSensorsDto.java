package com.lab6.dto;

import com.lab6.models.Position;
import com.lab6.models.Sensors;
import com.lab6.models.TransportSensors;

public class TransportSensorsDto {
    private TransportSensors transportSensors;

    public TransportSensorsDto(TransportSensors transportSensors){
        this.transportSensors = transportSensors;
    }

    public int getId() {
        return transportSensors.getId();
    }

    public Double getSpeed() {
        return transportSensors.getSpeed();
    }

    public Double getAmountOfGasoline() {
        return transportSensors.getAmountOfGasoline();
    }

    public Position getPositionId() {
        return transportSensors.getPositionId();
    }

    public Sensors getSensorsId() {
        return transportSensors.getSensorsId();
    }
}
