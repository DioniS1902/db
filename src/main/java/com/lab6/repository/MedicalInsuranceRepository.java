package com.lab6.repository;

import com.lab6.models.MedicalInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalInsuranceRepository extends JpaRepository<MedicalInsurance, Integer> {
}
