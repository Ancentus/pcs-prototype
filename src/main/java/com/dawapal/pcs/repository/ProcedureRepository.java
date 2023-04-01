package com.dawapal.pcs.repository;

import com.dawapal.pcs.model.Procedure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ancentus Makau
 * @version 1.0.0
 */

@Repository
public interface ProcedureRepository extends JpaRepository<Procedure, Long>{
    
}
