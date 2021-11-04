package com.lab4.controller;

import com.lab4.model.DAO.MedicalInsuranceDao;
import com.lab4.model.DAO.interfaces.GeneralDao;
import com.lab4.model.models.MedicalInsurance;

import java.util.Objects;

public class MedicalInsuranceController implements com.lab4.controller.interfaces.MedicalInsuranceController {
    private GeneralDao<MedicalInsurance, Integer> medicalInsuranceDao;

    @Override
    public GeneralDao<MedicalInsurance, Integer> generalDoa() {
        return Objects.requireNonNullElseGet(medicalInsuranceDao,() -> medicalInsuranceDao = new MedicalInsuranceDao());
    }
}
