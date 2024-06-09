package com.health.patientsystem.controller;

import com.health.patientsystem.exception.PatientNotFoundException;
import com.health.patientsystem.model.Consultation;
import com.health.patientsystem.model.Medcin;
import com.health.patientsystem.model.Patient;
import com.health.patientsystem.repository.ConsultationRepo;
import com.health.patientsystem.repository.MedcinRepo;
import com.health.patientsystem.repository.PatientRepo;
import com.health.patientsystem.service.PatientService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class PatientController {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private ConsultationRepo consultationRepo;
    @PostMapping("/patient")
    Patient newPatient(@RequestBody Patient newPatient) {
        return patientRepo.save(newPatient);
    }
    @GetMapping("/patients")
    List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }
    @GetMapping("/patient/{id}")
    Patient getPatientById(@PathVariable Long id) {
        return patientRepo.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(id));
    }


    @PutMapping("/patient/{id}")
    Patient updatePatient(@RequestBody Patient newPatient, @PathVariable Long id) {
        return patientRepo.findById(id)
                .map(patient -> {
                    patient.setAdresse(newPatient.getAdresse());
                    patient.setNom(newPatient.getNom());
                    patient.setPrenom(newPatient.getPrenom());
                    patient.setCIN(newPatient.getCIN());
                    patient.setDate_naissance(newPatient.getDate_naissance());
                    return patientRepo.save(patient);
                }).orElseThrow(() -> new PatientNotFoundException(id));
    }
    @DeleteMapping("/patient/{id}")
    String deletePatient(@PathVariable Long id){
        if(!patientRepo.existsById(id)){
            throw new PatientNotFoundException(id);
        }
        patientRepo.deleteById(id);
        return  "patient with id "+id+" has been deleted success.";
    }

    @GetMapping("/patient/{id}/consultations")
    public List<Consultation> getConsultationsByPatientId(@PathVariable Long id) {
        Patient patient = patientRepo.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(id));
        return consultationRepo.findByPatientId(id);
    }
    @GetMapping("/patients/count")
    public long countPatients() {
        return patientRepo.count();
    }











}
