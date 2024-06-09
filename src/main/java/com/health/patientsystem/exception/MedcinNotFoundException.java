package com.health.patientsystem.exception;

public class MedcinNotFoundException extends RuntimeException{
    public MedcinNotFoundException(Long id) {
        super("Patient not found with ID: " + id);
    }
}
