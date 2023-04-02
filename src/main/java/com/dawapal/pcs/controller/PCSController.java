package com.dawapal.pcs.controller;

import com.dawapal.pcs.model.CardiacArrest;
import com.dawapal.pcs.model.Incident;
import com.dawapal.pcs.model.Medication;
import com.dawapal.pcs.model.PCS;
import com.dawapal.pcs.model.Patient;
import com.dawapal.pcs.model.Procedure;
import com.dawapal.pcs.model.Vitals;
import com.dawapal.pcs.repository.CardiacArrestRepository;
import com.dawapal.pcs.repository.IncidentRepository;
import com.dawapal.pcs.repository.MedicationRepository;
import com.dawapal.pcs.repository.PatientRepository;
import com.dawapal.pcs.repository.ProcedureRepository;
import com.dawapal.pcs.repository.VitalsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ancentus
 * @version 1.0.0
 */

@CrossOrigin(maxAge = 3600)
@RestController
public class PCSController {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    IncidentRepository incidentRepository;

    @Autowired
    VitalsRepository vitalsRepository;

    @Autowired
    ProcedureRepository procedureRepository;

    @Autowired
    CardiacArrestRepository cardiacArrestRepository;

    @Autowired
    MedicationRepository medicationRepository;

    /**
     * @param pcs
     * @return ResponseEntity<String>
     *     gets data from client form and saves in the database
     */
    @PostMapping("/pcs/create")
    public ResponseEntity<String> createPCS(PCS pcs){
        // create and save patient
        Patient patient = new Patient();
        patient.setName(pcs.getName());
        patient.setAge(pcs.getAge());
        patient.setGender(pcs.getGender());
        patient.setPhone(pcs.getPhone());
        patient.setNok(pcs.getNok());
        patient.setNok_phone(pcs.getNok_phone());
        patient.setNok_relationship(pcs.getNok_relationship());

        patient = patientRepository.save(patient);

        // create and save incident
        Incident incident = new Incident();
        incident.setPatient(patient);
        incident.setCall_datetime(pcs.getCall_datetime());
        incident.setLocation(pcs.getLocation());
        incident.setComplaint(pcs.getComplaint());

        incident = incidentRepository.save(incident);
        long pcr_id = incident.getPcr_id();

        // create and save vitals
        Vitals vitals = new Vitals();
        vitals.setPcr_id(pcr_id);
        vitals.setVitals_date(pcs.getVitals_date());
        vitals.setVitals_time(pcs.getVitals_time());
        vitals.setSbp(pcs.getSbp());
        vitals.setDbp(pcs.getDbp());
        vitals.setMap(pcs.getMap());
        vitals.setGlasgow_eye(pcs.getGlasgow_eye());
        vitals.setGlasgow_verbal(pcs.getGlasgow_verbal());
        vitals.setGlasgow_motor(pcs.getGlasgow_motor());
        vitals.setGlasgow_qualifier(pcs.getGlasgow_qualifier());
        vitals.setGlasgow_total(pcs.getGlasgow_total());

        vitalsRepository.save(vitals);

        // create and save procedures
        int i = 0;
        for(String procedure_name : pcs.getProcedure_name()){
            Procedure procedure = new Procedure();
            procedure.setPcr_id(pcr_id);
            procedure.setProcedure_name(procedure_name);
            procedure.setProcedure_datetime(pcs.getProcedure_datetime().get(i));
            procedure.setAttempts(pcs.getAttempts().get(i));
            procedure.setSuccessful(pcs.getSuccessful().get(i));
            procedure.setProcedure_complication(pcs.getProcedure_complication().get(i));
            procedure.setProcedure_response(pcs.getProcedure_response().get(i));

            procedureRepository.save(procedure);
            i++;
        }

        // create and save medications
        i = 0;
        for(String med_name : pcs.getMed_name()){
            Medication medication = new Medication();
            medication.setPcr_id(pcr_id);
            medication.setMed_name(med_name);
            medication.setRoute(pcs.getRoute().get(i));
            medication.setDosage(pcs.getDosage().get(i));
            medication.setMed_response(pcs.getMed_response().get(i));
            medication.setMed_complication(pcs.getMed_complication().get(i));
            medication.setMed_datetime(pcs.getMed_datetime().get(i));

            medicationRepository.save(medication);
            i++;
        }

        // create and save cardiac arrest
        CardiacArrest cArrest = new CardiacArrest();
        cArrest.setPcr_id(pcr_id);
        cArrest.setCardiac_date(pcs.getCardiac_date());
        cArrest.setCardiac_time(pcs.getCardiac_time());
        cArrest.setCardiac_first_rhythm(pcs.getCardiac_first_rhythm());
        cArrest.setCardiac_resuscitation_attempted(pcs.getCardiac_resuscitation_attempted());
        cArrest.setCardiac_cpr_dateTime(pcs.getCardiac_cpr_dateTime());
        cArrest.setCardiac_spontaneous_return(pcs.getCardiac_spontaneous_return());
        cArrest.setCardiac_res_disc_dateTime(pcs.getCardiac_res_disc_dateTime());
        cArrest.setCardiac_dest_rhythm(pcs.getCardiac_dest_rhythm());
        cArrest.setCardiac_ecg(pcs.getCardiac_ecg());
        cArrest.setCardiac_ecg_type(pcs.getCardiac_ecg_type());
        cArrest.setCardiac_ecg_method(pcs.getCardiac_ecg_method());

        cardiacArrestRepository.save(cArrest);

        return new ResponseEntity<>("Summary saved successfully. PCR_NO: " + pcr_id, HttpStatus.OK);
    }
}
