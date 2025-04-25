package com.mftplus.patient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.mftplus.patient.controller.exception.NoContentException;
import com.mftplus.patient.dto.PatientAppointmentDto;
import com.mftplus.patient.model.Patient;
import com.mftplus.patient.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<Patient> save(@RequestBody PatientAppointmentDto patientAppointmentDto) throws JsonProcessingException, NoContentException {
        Patient patient = patientAppointmentDto.getPatient();
        patientService.save(patient);
        return ResponseEntity.ok(patient);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getPatients() {
        return ResponseEntity.ok(patientService.findAll());
    }

}
