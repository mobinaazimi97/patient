package com.mftplus.patient.controller;

import com.mftplus.patient.model.Doctor;
import com.mftplus.patient.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Doctor> createOrUpdateDoctor(@RequestBody Doctor doctor) {
        doctorService.save(doctor);
        return ResponseEntity.status(HttpStatus.OK).body(doctor);
    }

    @PutMapping("/update")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
//        Doctor updatedDoctor = doctorService.update(doctor);
        doctorService.update(doctor);
        return ResponseEntity.status(HttpStatus.OK).body(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
//        List<Doctor> doctors = doctorService.findAll();
        return ResponseEntity.ok(doctorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(doctor);
//        return doctor != null ? ResponseEntity.ok(doctor) : ResponseEntity.notFound().build();
    }

    @GetMapping("/skillName/{skillName}")
    public ResponseEntity<List<Doctor>> getDoctorBySkillName(@PathVariable String skillName) {
        return ResponseEntity.ok(doctorService.findBySkillName(skillName));
    }

    @GetMapping("/doctorName/{doctorName}")
    public ResponseEntity<List<Doctor>> getDoctorByDoctorName(@PathVariable String doctorName) {
        Doctor doctor = doctorService.findByDoctorName(doctorName).get(0);
        return ResponseEntity.ok(Collections.singletonList(doctor));
    }
}
