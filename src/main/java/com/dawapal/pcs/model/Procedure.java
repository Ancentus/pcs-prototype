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
 * This class represents a procedure entity in the system.
 * It maps to the "tblprocedure" table in the database.
 * 
 * @author Ancentus Makau
 * @version 1.0.0
 */

@Entity
@Table(name = "tblprocedure")
public class Procedure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long procedure_id;

    @ManyToOne
    @JoinColumn(name="pcr_id", nullable = false)
    private Incident incident;
    
    private String procedure_name;
    private String attempts;
    private String successful;
    private String procedure_response;
    private String procedure_complication;
    private String procedure_datetime;
    
    @JsonIgnore
    public Incident getIncident() {
        return incident;
    }

    @JsonIgnore
    public void setIncident(Incident incident) {
        this.incident = incident;
    }
    
    public Long getProcedure_id() {
        return procedure_id;
    }
    public void setProcedure_id(Long procedure_id) {
        this.procedure_id = procedure_id;
    }
    
    public String getProcedure_name() {
        return procedure_name;
    }
    public void setProcedure_name(String procedure_name) {
        this.procedure_name = procedure_name;
    }
    public String getAttempts() {
        return attempts;
    }
    public void setAttempts(String attempts) {
        this.attempts = attempts;
    }
    public String getSuccessful() {
        return successful;
    }
    public void setSuccessful(String successful) {
        this.successful = successful;
    }
    public String getProcedure_response() {
        return procedure_response;
    }
    public void setProcedure_response(String procedure_response) {
        this.procedure_response = procedure_response;
    }
    public String getProcedure_complication() {
        return procedure_complication;
    }
    public void setProcedure_complication(String procedure_complication) {
        this.procedure_complication = procedure_complication;
    }
    public String getProcedure_datetime() {
        return procedure_datetime;
    }
    public void setProcedure_datetime(String procedure_datetime) {
        this.procedure_datetime = procedure_datetime;
    }

    

}
