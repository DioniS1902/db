package com.lab6.repository;

import com.lab6.models.WorkerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerInfoRepository extends JpaRepository<WorkerInfo, Integer> {
}
