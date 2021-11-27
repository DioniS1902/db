package com.lab6.repository;

import com.lab6.models.WorkerSensors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerSensorsRepository extends JpaRepository<WorkerSensors, Integer> {
}
