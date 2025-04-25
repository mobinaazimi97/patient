package com.mftplus.patient.controller;

import com.mftplus.patient.model.Patient;
import com.mftplus.patient.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<?> getPatients() {
        return  ResponseEntity.ok(patientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findPatient(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.findById(id));
    }

}
