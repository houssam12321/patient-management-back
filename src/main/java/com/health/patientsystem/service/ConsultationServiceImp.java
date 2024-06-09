package com.health.patientsystem.service;

import com.health.patientsystem.model.Consultation;
import com.health.patientsystem.repository.ConsultationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConsultationServiceImp implements ConsultationService{
    @Autowired
    private ConsultationRepo consultationRepo;

    public List<Consultation> getConsultationsByPatientId(Long patientId) {
        return consultationRepo.findByPatientId(patientId);
    }


    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepo.save(consultation);
    }

    @Override
    public List<Consultation> getAllConsultations() {
        return consultationRepo.findAll();
    }
}
