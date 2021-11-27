package com.lab6.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "medical_insurance", schema = "career", catalog = "")
public class MedicalInsurance {
    private int id;
    private String medicCode;
    private MedicStatus medicId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
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
        return Objects.equals(medicCode, that.medicCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicCode);
    }

    @ManyToOne
    @JoinColumn(name = "medic_id", referencedColumnName = "id", nullable = false)
    public MedicStatus getMedicId() {
        return medicId;
    }

    public void setMedicId(MedicStatus medicId) {
        this.medicId = medicId;
    }
}
