package com.lab4.model.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "worker", schema = "career")
public class Worker extends GeneralModel{
    private int id;
    private int transportId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker that = (Worker) o;
        return id == that.id && transportId == that.transportId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transportId);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s |",id,transportId);
    }
}
