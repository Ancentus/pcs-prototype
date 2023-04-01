package com.dawapal.pcs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Ancentus Makau
 * @version 1.0.0
 */

@Controller
public class AppController {
     
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/new_incident")
    public String viewNewIncident() {
        return "new_incident";
    }
}
