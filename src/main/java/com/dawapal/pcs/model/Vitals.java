package com.dawapal.pcs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * This class represents a vitals entity in the system.
 * It maps to the "vitals" table in the database.
 * 
 * @author Ancentus Makau
 * @version 1.0.0
 */

@Entity
@Table(name = "vitals")
public class Vitals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vitals_id;

    private String vitals_date;
    private String vitals_time;
    private String sbp;
    private String dbp;
    private String map;
    private String glasgow_eye;
    private String glasgow_verbal;
    private String glasgow_motor;
    private String glasgow_qualifier;
    private String glasgow_total;

    @OneToOne(mappedBy = "vitals")
    Incident incident;
    
    public Incident getIncident() {
        return incident;
    }
    public void setIncident(Incident incident) {
        this.incident = incident;
    }
    public Long getVitals_id() {
        return vitals_id;
    }
    public void setVitals_id(Long vitals_id) {
        this.vitals_id = vitals_id;
    }
    
    public String getVitals_date() {
        return vitals_date;
    }
    public void setVitals_date(String vitals_date) {
        this.vitals_date = vitals_date;
    }
    public String getVitals_time() {
        return vitals_time;
    }
    public void setVitals_time(String vitals_time) {
        this.vitals_time = vitals_time;
    }
    public String getSbp() {
        return sbp;
    }
    public void setSbp(String sbp) {
        this.sbp = sbp;
    }
    public String getDbp() {
        return dbp;
    }
    public void setDbp(String dbp) {
        this.dbp = dbp;
    }
    public String getMap() {
        return map;
    }
    public void setMap(String map) {
        this.map = map;
    }
    public String getGlasgow_eye() {
        return glasgow_eye;
    }
    public void setGlasgow_eye(String glasgow_eye) {
        this.glasgow_eye = glasgow_eye;
    }
    public String getGlasgow_verbal() {
        return glasgow_verbal;
    }
    public void setGlasgow_verbal(String glasgow_verbal) {
        this.glasgow_verbal = glasgow_verbal;
    }
    public String getGlasgow_motor() {
        return glasgow_motor;
    }
    public void setGlasgow_motor(String glasgow_motor) {
        this.glasgow_motor = glasgow_motor;
    }
    public String getGlasgow_qualifier() {
        return glasgow_qualifier;
    }
    public void setGlasgow_qualifier(String glasgow_qualifier) {
        this.glasgow_qualifier = glasgow_qualifier;
    }
    public String getGlasgow_total() {
        return glasgow_total;
    }
    public void setGlasgow_total(String glasgow_total) {
        this.glasgow_total = glasgow_total;
    }

    
}
