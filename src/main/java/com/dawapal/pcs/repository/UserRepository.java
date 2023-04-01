package com.dawapal.pcs.repository;

import com.dawapal.pcs.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Ancentus Makau
 * @version 1.0.0
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @Query("SELECT u FROM User u WHERE u.login_name = ?1")
    public User findByUsername(String username);
}
