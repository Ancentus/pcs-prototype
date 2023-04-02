package com.dawapal.pcs.repository;

import java.util.List;

import com.dawapal.pcs.model.Incident;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ancentus Makau
 * @version 1.0.0
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class IncidentRepositoryTests {
   
    @Autowired
    private IncidentRepository repo;

    @Test
    public void testGetIncidentRecords(){
        List<Incident> allIncidents = repo.findAll();
        assertThat(allIncidents.size() > 0);
    }

    @Test
    public void testGetPatientName(){
        
        List<Incident> allIncidents = repo.findAll();
        for (Incident incident : allIncidents) {
            String name = incident.getPatient().getName();
            System.out.println(name);
        }
    }
}
