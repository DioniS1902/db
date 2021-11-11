package com.lab4.model.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "worker_sensors", schema = "career")
public class WorkerSensors extends GeneralModel{
    private int id;
    private Double temperature;
    private Double palpitation;
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
    @Column(name = "temperature")
    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Basic
    @Column(name = "palpitation")
    public Double getPalpitation() {
        return palpitation;
    }

    public void setPalpitation(Double palpitation) {
        this.palpitation = palpitation;
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
        WorkerSensors that = (WorkerSensors) o;
        return id == that.id && sensorsId == that.sensorsId && Objects.equals(temperature, that.temperature) && Objects.equals(palpitation, that.palpitation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, temperature, palpitation, sensorsId);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s | %-20s |",id, temperature, palpitation, sensorsId);
    }
}
