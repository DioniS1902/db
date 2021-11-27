package com.lab6.repository;

import com.lab6.models.MedicStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicStatusRepository extends JpaRepository<MedicStatus, Integer> {
}
