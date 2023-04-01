package com.dawapal.pcs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This class represents a patient entity in the system.
 * It maps to the "patient" table in the database.
 * 
 * @author Ancentus Makau
 * @version 1.0.0
 */

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patient_id;

    private String name;
    private String gender;
    private int age;
    private String phone;
    private String nok;
    private String nok_phone;
    private String nok_relationship;
    
    public Long getPatient_id() {
        return patient_id;
    }
    public void setPatient_id(Long patient_id) {
        this.patient_id = patient_id;
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

    
}
