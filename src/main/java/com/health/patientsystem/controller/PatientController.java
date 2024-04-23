package com.health.patientsystem.controller;

import com.health.patientsystem.model.Patient;
import com.health.patientsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@CrossOrigin("http://localhost:3000")

public class PatientController {
    @Autowired
    private PatientService patientService;
    @PostMapping("/add")
    public String add(@RequestBody Patient patient){
        patientService.savePatient(patient);
        return "nouveau patient ajoute";
    }
    @GetMapping("/getAll")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

}