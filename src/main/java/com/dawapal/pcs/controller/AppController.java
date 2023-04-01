package com.dawapal.pcs.controller;

import com.dawapal.pcs.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Ancentus Makau
 * @version 1.0.0
 */

@Controller
public class AppController {
    @Autowired
    private UserRepository userRepo;
     
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
}
