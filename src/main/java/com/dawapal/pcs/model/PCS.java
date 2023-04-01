package com.dawapal.pcs.model;

import java.util.List;

/**
 * @author ancentus
 * @version 1.0.0
 */

public class PCS {
    // Incident
    private String call_datetime;
    private String location;
    private String complaint;

    // Patient
    private String name;
    private String gender;
    private int age;
    private String phone;
    private String nok;
    private String nok_phone;
    private String nok_relationship;

    // Vitals
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

    // Medications
    private List<String> med_name;
    private List<String> dosage;
    private List<String> route;
    private List<String> med_response;
    private List<String> med_complication;
    private List<String> med_datetime;

    // Procedures
    private List<String> procedure_name;
    private List<String> attempts;
    private List<String> successful;
    private List<String> procedure_response;
    private List<String> procedure_complication;
    private List<String> procedure_datetime;
    
    // Cardiac Arrest
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
    
    // Empty constructor

    public PCS() {
    }

    // Getters and Setters

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNok() {
        return nok;
    }

    public void setNok(String nok) {
        this.nok = nok;
    }

    public String getNok_phone() {
        return nok_phone;
    }

    public void setNok_phone(String nok_phone) {
        this.nok_phone = nok_phone;
    }

    public String getNok_relationship() {
        return nok_relationship;
    }

    public void setNok_relationship(String nok_relationship) {
        this.nok_relationship = nok_relationship;
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

    public List<String> getMed_name() {
        return med_name;
    }

    public void setMed_name(List<String> med_name) {
        this.med_name = med_name;
    }

    public List<String> getDosage() {
        return dosage;
    }

    public void setDosage(List<String> dosage) {
        this.dosage = dosage;
    }

    public List<String> getRoute() {
        return route;
    }

    public void setRoute(List<String> route) {
        this.route = route;
    }

    public List<String> getMed_response() {
        return med_response;
    }

    public void setMed_response(List<String> med_response) {
        this.med_response = med_response;
    }

    public List<String> getMed_complication() {
        return med_complication;
    }

    public void setMed_complication(List<String> med_complication) {
        this.med_complication = med_complication;
    }

    public List<String> getMed_datetime() {
        return med_datetime;
    }

    public void setMed_datetime(List<String> med_datetime) {
        this.med_datetime = med_datetime;
    }

    public List<String> getProcedure_name() {
        return procedure_name;
    }

    public void setProcedure_name(List<String> procedure_name) {
        this.procedure_name = procedure_name;
    }

    public List<String> getAttempts() {
        return attempts;
    }

    public void setAttempts(List<String> attempts) {
        this.attempts = attempts;
    }

    public List<String> getSuccessful() {
        return successful;
    }

    public void setSuccessful(List<String> successful) {
        this.successful = successful;
    }

    public List<String> getProcedure_response() {
        return procedure_response;
    }

    public void setProcedure_response(List<String> procedure_response) {
        this.procedure_response = procedure_response;
    }

    public List<String> getProcedure_complication() {
        return procedure_complication;
    }

    public void setProcedure_complication(List<String> procedure_complication) {
        this.procedure_complication = procedure_complication;
    }

    public List<String> getProcedure_datetime() {
        return procedure_datetime;
    }

    public void setProcedure_datetime(List<String> procedure_datetime) {
        this.procedure_datetime = procedure_datetime;
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
