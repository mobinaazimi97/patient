package com.mftplus.patient.service;


import com.mftplus.patient.model.Doctor;
import com.mftplus.patient.repository.DoctorRepository;
import com.mftplus.patient.repository.SpecializationRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final SpecializationRepository specializationRepository;

    public DoctorService(DoctorRepository doctorRepository, SpecializationRepository specializationRepository) {
        this.doctorRepository = doctorRepository;
        this.specializationRepository = specializationRepository;
    }
    @CacheEvict(cacheNames = "doctors", allEntries = true)
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }


    @CacheEvict(cacheNames = "doctors", allEntries = true)
    public Doctor update(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Delete Doctor
    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }

    // Get All Doctors
    @CacheEvict(cacheNames = "doctors", allEntries = true)
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    // Get Doctor by ID
    @CacheEvict(cacheNames = "doctors", allEntries = true)
    public Doctor findById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + id));
    }

    @CacheEvict(cacheNames = "doctors", allEntries = true)
    public List<Doctor> findByDoctorName(String doctorName) {
        return doctorRepository.findByDoctorName(doctorName);
    }

    @CacheEvict(cacheNames = "doctors", allEntries = true)
    public List<Doctor> findBySkillName(String skillName) {
        return doctorRepository.findBySkillName(skillName);
    }


    @CacheEvict(cacheNames = "doctors", allEntries = true)
    public Doctor findByDoctorNameAndSpecialization(String skillName, String doctorName) {

//        Specialization specialization=specializationRepository.findBySkillName(skillName).get(0);
        return doctorRepository.findByDoctorNameAndSpecialization(skillName, doctorName);

    }

}
