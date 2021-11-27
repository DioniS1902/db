package com.lab6.repository;

import com.lab6.models.Career;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CareerRepository extends JpaRepository<Career, Integer> {
}
