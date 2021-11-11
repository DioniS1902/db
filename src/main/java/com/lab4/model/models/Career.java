package com.lab4.model.models;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "career", schema = "career")
public class Career extends GeneralModel{
    private int id;
    private String name;
    private Position positionId;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id", nullable = false)
    public Position getPositionId() {
        return positionId;
    }

    public void setPositionId(Position positionId) {
        this.positionId = positionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Career that = (Career) o;
        return id == that.id && positionId == that.positionId && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, positionId);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s |",id,name,positionId);
    }
}
