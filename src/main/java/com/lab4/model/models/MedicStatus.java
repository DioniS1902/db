package com.lab4.model.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "medic_status", schema = "career")
public class MedicStatus extends GeneralModel{
    private int id;
    private Date date;
    private Double temperature;
    private int workerId;

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
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
    @Column(name = "worker_id")
    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicStatus that = (MedicStatus) o;
        return id == that.id && workerId == that.workerId && Objects.equals(date, that.date) && Objects.equals(temperature, that.temperature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, temperature, workerId);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s | %-20s |",id,date, temperature, workerId);
    }
}
