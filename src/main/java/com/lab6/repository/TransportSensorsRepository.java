package com.lab6.repository;

import com.lab6.models.TransportSensors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportSensorsRepository extends JpaRepository<TransportSensors, Integer> {
}
