package com.dawapal.pcs.repository;

import com.dawapal.pcs.model.Vitals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ancentus Makau
 * @version 1.0.0
 */

@Repository
public interface VitalsRepository extends JpaRepository<Vitals, Long>{
    
}
