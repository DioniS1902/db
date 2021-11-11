package com.lab4.model.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "medical_insurance", schema = "career")
public class MedicalInsurance extends GeneralModel{
    private int medicId;
    private String medicCode;

    @Id
    @Column(name = "medic_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getMedicId() {
        return medicId;
    }

    public void setMedicId(int medicId) {
        this.medicId = medicId;
    }

    @Basic
    @Column(name = "medic_code")
    public String getMedicCode() {
        return medicCode;
    }

    public void setMedicCode(String medicCode) {
        this.medicCode = medicCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalInsurance that = (MedicalInsurance) o;
        return medicId == that.medicId && Objects.equals(medicCode, that.medicCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicId, medicCode);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s |",medicId,medicCode);
    }
}
