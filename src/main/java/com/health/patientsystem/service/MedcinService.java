package com.health.patientsystem.service;

import com.health.patientsystem.model.Medcin;
import com.health.patientsystem.model.Patient;

import java.util.List;

public interface MedcinService {
    public Medcin saveMedcin(Medcin medcin);
    public List<Medcin> getAllMedcins();
}
