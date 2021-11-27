package com.lab6.dto;

import com.lab6.models.MedicStatus;
import com.lab6.models.MedicalInsurance;

public class MedicalInsuranceDto {
    private MedicalInsurance medicalInsurance;

    public int getId() {
        return medicalInsurance.getId();
    }

    public MedicalInsuranceDto(MedicalInsurance medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    public MedicStatus getMedicId() {
        return medicalInsurance.getMedicId();
    }

    public String getMedicCode() {
        return medicalInsurance.getMedicCode();
    }
}
