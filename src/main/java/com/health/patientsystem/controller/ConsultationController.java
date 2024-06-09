package com.health.patientsystem.controller;

import com.health.patientsystem.exception.ConsultationNotFoundException;
import com.health.patientsystem.exception.PatientNotFoundException;
import com.health.patientsystem.model.Consultation;
import com.health.patientsystem.model.Patient;
import com.health.patientsystem.model.Medcin;
import com.health.patientsystem.repository.ConsultationRepo;
import com.health.patientsystem.repository.PatientRepo;
import com.health.patientsystem.repository.MedcinRepo;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("http://localhost:3000")
public class ConsultationController {

    @Autowired
    private ConsultationRepo consultationRepo;

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private MedcinRepo medcinRepo;

    @PostMapping("/consultation")
    public Consultation newConsultation(@RequestBody Consultation newConsultation) {
        Optional<Patient> patientOpt = patientRepo.findById(newConsultation.getPatient().getId());
        Optional<Medcin> medcinOpt = medcinRepo.findById(newConsultation.getMedcin().getId());

        if (patientOpt.isPresent() && medcinOpt.isPresent()) {
            newConsultation.setPatient(patientOpt.get());
            newConsultation.setMedcin(medcinOpt.get());
            return consultationRepo.save(newConsultation);
        } else {
            throw new RuntimeException("Patient or Medcin not found");
        }
    }

    @GetMapping("/consultations")
    public List<Consultation> getAllConsultations() {
        return consultationRepo.findAll();
    }

    @GetMapping("/consultation/{id}")
    public Consultation getConsultationById(@PathVariable Long id) {
        return consultationRepo.findById(id)
                .orElseThrow(() -> new ConsultationNotFoundException(id));
    }

    @PutMapping("/consultation/{id}")
    public Consultation updateConsultation(@RequestBody Consultation newConsultation, @PathVariable Long id) {
        return consultationRepo.findById(id)
                .map(consultation -> {
                    consultation.setDateConsultation(newConsultation.getDateConsultation());
                    consultation.setCommentaire(newConsultation.getCommentaire());
                    consultation.setMedcin(newConsultation.getMedcin());
                    consultation.setMotif(newConsultation.getMotif());
                    consultation.setPatient(newConsultation.getPatient());
                    consultation.setFraisConsultation(newConsultation.getFraisConsultation());
                    return consultationRepo.save(consultation);
                })
                .orElseGet(() -> {
                    newConsultation.setId(id);
                    return consultationRepo.save(newConsultation);
                });
    }

    @DeleteMapping("/consultation/{id}")
    public void deleteConsultation(@PathVariable Long id) {
        consultationRepo.findById(id)
                .orElseThrow(() -> new ConsultationNotFoundException(id));
        consultationRepo.deleteById(id);
    }

    @GetMapping("/consultations/count")
    public long countConsultations() {
        return consultationRepo.count();
    }


}
