package com.dawapal.pcs.controller;

import com.dawapal.pcs.repository.IncidentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Ancentus Makau
 * @version 1.0.0
 */

@Controller
public class AppController {

    @Autowired
    IncidentRepository iRepository;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/new_incident")
    public String viewNewIncident() {
        return "new_incident";
    }

    @GetMapping("/view_records")
    public String viewAllIncidents(Model model) {
        model.addAttribute("records", iRepository.findAll());
        return "view_records";
    }

    @GetMapping("/view_pcr")
    public String viewAllIncidents(long pcr_id, Model model) {

        model.addAttribute("pcr", iRepository.findById(pcr_id).get());

        return "view_pcr";
    }
}
