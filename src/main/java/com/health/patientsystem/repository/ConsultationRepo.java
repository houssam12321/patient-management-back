package com.health.patientsystem.repository;

import com.health.patientsystem.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultationRepo extends JpaRepository<Consultation,Long> {

    List<Consultation> findByPatientId(Long patientId);
}
