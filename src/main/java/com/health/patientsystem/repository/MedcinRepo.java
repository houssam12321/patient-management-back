package com.health.patientsystem.repository;

import com.health.patientsystem.model.Medcin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedcinRepo extends JpaRepository<Medcin,Long> {
}
