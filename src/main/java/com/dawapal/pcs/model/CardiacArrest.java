package com.dawapal.pcs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * This class represents a cardiac arrest entity in the system.
 * It maps to the "cardiacarrest" table in the database.
 * 
 * @author Ancentus Makau
 * @version 1.0.0
 */

@Entity
@Table(name = "cardiacarrest")
public class CardiacArrest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardiac_arrest_id;

    @OneToOne(mappedBy = "cardiacArrest")
    Incident incident;
    
    private String cardiac_date;
    private String cardiac_time;
    private String cardiac_ecg;
    private String cardiac_ecg_type;
    private String cardiac_ecg_method;
    private String cardiac_first_rhythm;
    private String cardiac_resuscitation_attempted;
    private String cardiac_cpr_dateTime;
    private String cardiac_spontaneous_return;
    private String cardiac_res_disc_dateTime;
    private String cardiac_dest_rhythm;

    
    public Incident getIncident() {
        return incident;
    }
    public void setIncident(Incident incident) {
        this.incident = incident;
    }
    
    public Long getCardiac_arrest_id() {
        return cardiac_arrest_id;
    }
    public void setCardiac_arrest_id(Long cardiac_arrest_id) {
        this.cardiac_arrest_id = cardiac_arrest_id;
    }
    
    public String getCardiac_date() {
        return cardiac_date;
    }
    public void setCardiac_date(String cardiac_date) {
        this.cardiac_date = cardiac_date;
    }
    public String getCardiac_time() {
        return cardiac_time;
    }
    public void setCardiac_time(String cardiac_time) {
        this.cardiac_time = cardiac_time;
    }
    public String getCardiac_ecg() {
        return cardiac_ecg;
    }
    public void setCardiac_ecg(String cardiac_ecg) {
        this.cardiac_ecg = cardiac_ecg;
    }
    public String getCardiac_ecg_type() {
        return cardiac_ecg_type;
    }
    public void setCardiac_ecg_type(String cardiac_ecg_type) {
        this.cardiac_ecg_type = cardiac_ecg_type;
    }
    public String getCardiac_ecg_method() {
        return cardiac_ecg_method;
    }
    public void setCardiac_ecg_method(String cardiac_ecg_method) {
        this.cardiac_ecg_method = cardiac_ecg_method;
    }
    public String getCardiac_first_rhythm() {
        return cardiac_first_rhythm;
    }
    public void setCardiac_first_rhythm(String cardiac_first_rhythm) {
        this.cardiac_first_rhythm = cardiac_first_rhythm;
    }
    public String getCardiac_resuscitation_attempted() {
        return cardiac_resuscitation_attempted;
    }
    public void setCardiac_resuscitation_attempted(String cardiac_resuscitation_attempted) {
        this.cardiac_resuscitation_attempted = cardiac_resuscitation_attempted;
    }
    public String getCardiac_cpr_dateTime() {
        return cardiac_cpr_dateTime;
    }
    public void setCardiac_cpr_dateTime(String cardiac_cpr_dateTime) {
        this.cardiac_cpr_dateTime = cardiac_cpr_dateTime;
    }
    public String getCardiac_spontaneous_return() {
        return cardiac_spontaneous_return;
    }
    public void setCardiac_spontaneous_return(String cardiac_spontaneous_return) {
        this.cardiac_spontaneous_return = cardiac_spontaneous_return;
    }
    public String getCardiac_res_disc_dateTime() {
        return cardiac_res_disc_dateTime;
    }
    public void setCardiac_res_disc_dateTime(String cardiac_res_disc_dateTime) {
        this.cardiac_res_disc_dateTime = cardiac_res_disc_dateTime;
    }
    public String getCardiac_dest_rhythm() {
        return cardiac_dest_rhythm;
    }
    public void setCardiac_dest_rhythm(String cardiac_dest_rhythm) {
        this.cardiac_dest_rhythm = cardiac_dest_rhythm;
    }

    
}
