package com.lab4.model.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "worker_info", schema = "career")
public class WorkerInfo extends GeneralModel{
    private int workerId;
    private String firstName;
    private String lastName;
    private Date birhday;

    @Id
    @Column(name = "worker_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "birhday")
    public Date getBirhday() {
        return birhday;
    }

    public void setBirhday(Date birhday) {
        this.birhday = birhday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerInfo that = (WorkerInfo) o;
        return workerId == that.workerId && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(birhday, that.birhday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workerId, firstName, lastName, birhday);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s | %-20s |",workerId, firstName, lastName, birhday);
    }
}
