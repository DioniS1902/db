package com.lab6.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "worker_sensors", schema = "career", catalog = "")
public class WorkerSensors {
    private int id;
    private Double temperature;
    private Double palpitation;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerSensors that = (WorkerSensors) o;
        return id == that.id && Objects.equals(temperature, that.temperature) && Objects.equals(palpitation, that.palpitation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, temperature, palpitation);
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
