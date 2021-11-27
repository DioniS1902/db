package com.lab6.service;

import com.lab6.models.MedicalInsurance;
import com.lab6.repository.MedicalInsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class MedicalInsuranceService {
    @Autowired
    public MedicalInsuranceRepository medicalInsuranceRepository;

    public MedicalInsurance addMedicalInsurance(final MedicalInsurance medicalInsurance) {
        return medicalInsuranceRepository.save(medicalInsurance);
    }

    public MedicalInsurance updateMedicalInsurance(final MedicalInsurance medicalInsurance) {
        return medicalInsuranceRepository.save(medicalInsurance);
    }

    public List<MedicalInsurance> getMedicalInsurance() {
        return medicalInsuranceRepository.findAll();
    }

    public MedicalInsurance getMedicalInsuranceId(final Integer id) {
        return medicalInsuranceRepository.findById(id).orElse(null);
    }

    public void deleteMedicalInsuranceById(Integer id){
        medicalInsuranceRepository.deleteById(id);
    }
}
