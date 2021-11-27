package com.lab6.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "transport_sesnsors", schema = "career", catalog = "")
public class TransportSensors {
    private int id;
    private Double speed;
    private Double amountOfGasoline;
    private Position positionId;
    private Sensors sensorsId;

    @Id
    @Column(name = "id")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportSensors that = (TransportSensors) o;
        return id == that.id && Objects.equals(speed, that.speed) && Objects.equals(amountOfGasoline, that.amountOfGasoline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, speed, amountOfGasoline);
    }

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id", nullable = false)
    public Position getPositionId() {
        return positionId;
    }

    public void setPositionId(Position positionId) {
        this.positionId = positionId;
    }

    @ManyToOne
    @JoinColumn(name = "sensors_id", referencedColumnName = "id", nullable = false)
    public Sensors getSensorsId() {
        return sensorsId;
    }

    public void setSensorsId(Sensors sensorsId) {
        this.sensorsId = sensorsId;
    }
}
