package com.lab4.model.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "position", schema = "career")
public class Position extends GeneralModel{
    private int id;
    private Double p_lat;
    private Double p_long;

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
    @Column(name = "lat")
    public Double getP_lat() {
        return p_lat;
    }

    public void setP_lat(Double p_lat) {
        this.p_lat = p_lat;
    }

    @Basic
    @Column(name = "plong")
    public Double getP_long() {
        return p_long;
    }

    public void setP_long(Double p_long) {
        this.p_long = p_long;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position that = (Position) o;
        return id == that.id && Objects.equals(p_lat, that.p_lat) && Objects.equals(p_long, that.p_long);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, p_lat, p_long);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s |",id,p_lat, p_long);
    }
}
