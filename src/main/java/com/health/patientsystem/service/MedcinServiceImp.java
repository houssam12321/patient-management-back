package com.health.patientsystem.service;

import com.health.patientsystem.model.Medcin;
import com.health.patientsystem.model.Patient;
import com.health.patientsystem.repository.MedcinRepo;
import com.health.patientsystem.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedcinServiceImp implements MedcinService{
    @Autowired
    private MedcinRepo medcinRepo;


    @Override
    public Medcin saveMedcin(Medcin medcin) {
        return medcinRepo.save(medcin);
    }

    @Override
    public List<Medcin> getAllMedcins() {
        return medcinRepo.findAll();
    }
}
