package com.health.patientsystem.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateConsultation;
    private String motif;
    private String commentaire;
    @Column(name = "frais_consultation")
    private double fraisConsultation; // Ajout du champ frais de consultation


    public double getFraisConsultation() {
        return fraisConsultation;
    }

    public void setFraisConsultation(double fraisConsultation) {
        this.fraisConsultation = fraisConsultation;
    }

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "medcin_id")
    private Medcin medcin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medcin getMedcin() {
        return medcin;
    }

    public void setMedcin(Medcin medcin) {
        this.medcin = medcin;
    }
}
