package com.dawapal.pcs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * This class represents a medication entity in the system.
 * It maps to the "medication" table in the database.
 * 
 * @author Ancentus Makau
 * @version 1.0.0
 */

@Entity
@Table(name = "medication")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medication_id;

    @ManyToOne
    @JoinColumn(name="pcr_id", nullable = false)
    private Incident incident;
    
    private String med_name;
    private String dosage;
    private String route;
    private String med_response;
    private String med_complication;
    private String med_datetime;
    
    @JsonIgnore
    public Incident getIncident() {
        return incident;
    }

    @JsonIgnore
    public void setIncident(Incident incident) {
        this.incident = incident;
    }
    
    public Long getMedication_id() {
        return medication_id;
    }
    public void setMedication_id(Long medication_id) {
        this.medication_id = medication_id;
    }
    
    public String getMed_name() {
        return med_name;
    }
    public void setMed_name(String med_name) {
        this.med_name = med_name;
    }
    public String getDosage() {
        return dosage;
    }
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
    public String getRoute() {
        return route;
    }
    public void setRoute(String route) {
        this.route = route;
    }
    public String getMed_response() {
        return med_response;
    }
    public void setMed_response(String med_response) {
        this.med_response = med_response;
    }
    public String getMed_complication() {
        return med_complication;
    }
    public void setMed_complication(String med_complication) {
        this.med_complication = med_complication;
    }
    public String getMed_datetime() {
        return med_datetime;
    }
    public void setMed_datetime(String med_datetime) {
        this.med_datetime = med_datetime;
    }

    
}
