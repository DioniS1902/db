package com.lab6.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Position {
    private int id;
    private Double lat;
    private Double plong;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "lat")
    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Basic
    @Column(name = "plong")
    public Double getPlong() {
        return plong;
    }

    public void setPlong(Double plong) {
        this.plong = plong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return id == position.id && Objects.equals(lat, position.lat) && Objects.equals(plong, position.plong);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lat, plong);
    }
}
