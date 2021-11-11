package com.lab4.model.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "transport", schema = "career")
public class Transport extends GeneralModel{
    private int id;
    private String model;
    private String transportcol;
    private int careerId;

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
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "transportcol")
    public String getTransportcol() {
        return transportcol;
    }

    public void setTransportcol(String transportcol) {
        this.transportcol = transportcol;
    }

    @Basic
    @Column(name = "career_id")
    public int getCareerId() {
        return careerId;
    }

    public void setCareerId(int careerId) {
        this.careerId = careerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport that = (Transport) o;
        return id == that.id && careerId == that.careerId && Objects.equals(model, that.model) && Objects.equals(transportcol, that.transportcol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, transportcol, careerId);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s | %-20s |",id,model, transportcol, careerId);
    }
}
