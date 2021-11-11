package com.lab4.model.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sensors", schema = "career")
public class Sensors extends GeneralModel{
    private int id;
    private int transportId;
    private String dateTime;

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
    @Column(name = "transport_id")
    public int getTransportId() {
        return transportId;
    }

    public void setTransportId(int transportId) {
        this.transportId = transportId;
    }

    @Basic
    @Column(name = "date_time")
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensors that = (Sensors) o;
        return id == that.id && transportId == that.transportId && Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transportId, dateTime);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s |",id,transportId, dateTime);
    }
}
