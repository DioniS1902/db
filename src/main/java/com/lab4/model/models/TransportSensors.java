package com.lab4.model.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "transport_sesnsors", schema = "career")
public class TransportSensors extends GeneralModel{
    private int id;
    private Double speed;
    private Double amountOfGasoline;
    private int positionId;
    private int sensorsId;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "speed")
    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    @Basic
    @Column(name = "amount_of_gasoline")
    public Double getAmountOfGasoline() {
        return amountOfGasoline;
    }

    public void setAmountOfGasoline(Double amountOfGasoline) {
        this.amountOfGasoline = amountOfGasoline;
    }

    @Basic
    @Column(name = "position_id")
    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    @Basic
    @Column(name = "sensors_id")
    public int getSensorsId() {
        return sensorsId;
    }

    public void setSensorsId(int sensorsId) {
        this.sensorsId = sensorsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportSensors that = (TransportSensors) o;
        return id == that.id && positionId == that.positionId && sensorsId == that.sensorsId && Objects.equals(speed, that.speed) && Objects.equals(amountOfGasoline, that.amountOfGasoline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, speed, amountOfGasoline, positionId, sensorsId);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s | %-20s | %-20s |",id,speed, amountOfGasoline, positionId, sensorsId);
    }
}
