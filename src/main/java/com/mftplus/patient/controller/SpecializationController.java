package com.mftplus.patient.controller;

import com.mftplus.patient.model.Specialization;
import com.mftplus.patient.service.SpecializationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/specializations")
public class SpecializationController {
    private final SpecializationService specializationService;

    public SpecializationController(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    // Create or Update Specialization
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Specialization> createOrUpdateSpecialization(@RequestBody Specialization specialization) {
        specializationService.save(specialization);
        return ResponseEntity.status(HttpStatus.OK).body(specialization);
    }

    // Update Specialization by ID
    @PutMapping("/update")
    public ResponseEntity<Specialization> updateSpecialization(@RequestBody Specialization specialization) {
        specializationService.update(specialization);
        return ResponseEntity.status(HttpStatus.OK).body(specialization);
    }

    // Delete Specialization by ID
    @DeleteMapping("/{id}")
    public void deleteSpecialization(@PathVariable Long id) {
        specializationService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<Specialization>> getAllSpecializations() {
        return ResponseEntity.ok(specializationService.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialization> getSpecializationById(@PathVariable Long id) {
        Specialization specialization = specializationService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(specialization);

    }

    @GetMapping("/skillName/{skillName}")
    public ResponseEntity<Specialization> getSpecializationByName(@PathVariable String skillName) {
        Specialization specialization = specializationService.findBySkillName(skillName);
        return ResponseEntity.status(HttpStatus.OK).body(specialization);
    }

    @GetMapping("/doctorName/{doctorName}")
    public ResponseEntity<List<Specialization>> getSpecializationByDoctorName(@PathVariable String doctorName) {
        List<Specialization> specializations = specializationService.findByDoctorName(doctorName);
        return ResponseEntity.ok(Collections.singletonList(specializations.get(0)));

    }
}
