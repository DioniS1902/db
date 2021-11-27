package com.lab6.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Transport {
    private int id;
    private String model;
    private String transportcol;
    private Career careerId;

    @Id
    @Column(name = "id")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return id == transport.id && Objects.equals(model, transport.model) && Objects.equals(transportcol, transport.transportcol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, transportcol);
    }

    @ManyToOne
    @JoinColumn(name = "career_id", referencedColumnName = "id", nullable = false)
    public Career getCareerId() {
        return careerId;
    }

    public void setCareerId(Career careerId) {
        this.careerId = careerId;
    }
}
