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
 * This class represents an incident entity in the system.
 * It maps to the "incident" table in the database.
 * 
 * @author Ancentus Makau
 * @version 1.0.0
 */

@Entity
@Table(name = "incident")
public class Incident {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pcr_id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
    private String call_datetime;
    private String location;
    private String complaint;
    
    public Long getPcr_id() {
        return pcr_id;
    }
    public void setPcr_id(Long pcr_id) {
        this.pcr_id = pcr_id;
    }

    @JsonIgnore
    public Patient getPatient() {
        return patient;
    }

    @JsonIgnore
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
   
    public String getCall_datetime() {
        return call_datetime;
    }
    public void setCall_datetime(String call_datetime) {
        this.call_datetime = call_datetime;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getComplaint() {
        return complaint;
    }
    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

}
