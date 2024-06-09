package com.health.patientsystem.exception;

public class ConsultationNotFoundException extends RuntimeException{
    public ConsultationNotFoundException(Long id) {
        super("consultation not found with ID: " + id);
    }
}
