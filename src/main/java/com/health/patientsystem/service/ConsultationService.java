package com.health.patientsystem.service;

import com.health.patientsystem.model.Consultation;
import com.health.patientsystem.model.Medcin;
import com.health.patientsystem.repository.ConsultationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface ConsultationService {

    List<Consultation> getConsultationsByPatientId(Long patientId);

    public Consultation saveConsultation(Consultation consultation);
    public List<Consultation> getAllConsultations();
}
