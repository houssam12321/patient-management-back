package com.health.patientsystem.controller;

import com.health.patientsystem.exception.MedcinNotFoundException;
import com.health.patientsystem.model.Medcin;
import com.health.patientsystem.model.Patient;
import com.health.patientsystem.repository.MedcinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("http://localhost:3000")


public class MedcinController {
    @Autowired

    private MedcinRepo medcinRepo;
    @PostMapping("/medcin")
    Medcin newMedcin(@RequestBody Medcin newMedcin) {
        return medcinRepo.save(newMedcin);
    }
    @GetMapping("/medcins")
    List<Medcin> getAllMedcins() {
        return medcinRepo.findAll();
    }

    @GetMapping("/medcin/{id}")
    Medcin getMedcinById(@PathVariable Long id) {
        return medcinRepo.findById(id)
                .orElseThrow(() -> new MedcinNotFoundException(id));
    }


    @PutMapping("/medcin/{id}")
    Medcin updateMedcin(@RequestBody Medcin newMedcin, @PathVariable Long id) {
        return medcinRepo.findById(id)
                .map(medcin -> {
                    medcin.setAdresse(newMedcin.getAdresse());
                    medcin.setNom(newMedcin.getNom());
                    medcin.setPrenom(newMedcin.getPrenom());
                    medcin.setDate_naissance(newMedcin.getDate_naissance());
                    medcin.setSpecialite(newMedcin.getSpecialite());
                    medcin.setCin(newMedcin.getCin());


                    return medcinRepo.save(medcin);
                }).orElseThrow(() -> new MedcinNotFoundException(id));
    }

    @DeleteMapping("/medcin/{id}")
    String deleteMedcin(@PathVariable Long id){
        if(!medcinRepo.existsById(id)){
            throw new MedcinNotFoundException(id);
        }
        medcinRepo.deleteById(id);
        return  "medcin with id "+id+" has been deleted success.";
    }

    @GetMapping("/medcins/count")
    public long countMedcins() {
        return medcinRepo.count();
    }
}
