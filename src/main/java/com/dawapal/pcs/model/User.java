package com.dawapal.pcs.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This class represents a user entity in the system.
 * It maps to the "User" table in the database.
 * 
 * @author Ancentus Makau
 * @version 1.0.0
 */

@Entity
@Table(name = "user")
public class User {
    /**
     * The primary key of the user entity.
     * It maps to the "user_id" column in the "User" table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    /**
     * The login name of the user.
     * It maps to the "login_name" column in the "User" table.
     */
    @Column(nullable = false, unique = true, length = 20)
    private String login_name;

    /**
     * The full name of the user.
     * It maps to the "full_name" column in the "User" table.
     */
    private String full_name;

    /**
     * The type of the user.
     * It maps to the "user_type" column in the "User" table.
     */
    private String user_type;

    /**
     * The password of the user.
     * It maps to the "password" column in the "User" table.
     */
    private String password;

    /**
     * Returns the user id.
     * 
     * @return the user id.
     */
    public Long getUser_id() {
        return user_id;
    }

    /**
     * Sets the user id.
     * 
     * @param user_id the user id.
     */
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    /**
     * Returns the login name.
     * 
     * @return the login name.
     */
    public String getLogin_name() {
        return login_name;
    }

    /**
     * Sets the login name.
     * 
     * @param login_name the login name.
     */
    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    /**
     * Returns the full name.
     * 
     * @return the full name.
     */
    public String getFull_name() {
        return full_name;
    }

    /**
     * Sets the full name.
     * 
     * @param full_name the full name.
     */
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    /**
     * Returns the user type.
     * 
     * @return the user type.
     */
    public String getUser_type() {
        return user_type;
    }

    /**
     * Sets the user type.
     * 
     * @param user_type the user type.
     */
    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    /**
     * Returns the password.
     * 
     * @return the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     * 
     * @param password the password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
