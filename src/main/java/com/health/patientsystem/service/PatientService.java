package com.health.patientsystem.service;

import com.health.patientsystem.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    public Patient savePatient(Patient patient);
    public List<Patient> getAllPatients();

}
