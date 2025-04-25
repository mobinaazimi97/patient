package com.mftplus.patient.service;

import com.mftplus.patient.model.Patient;
import com.mftplus.patient.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Transactional
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Transactional
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Transactional
    public Patient findById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }
}
