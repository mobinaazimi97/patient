package com.mftplus.patient.service;


import com.mftplus.patient.model.Specialization;
import com.mftplus.patient.repository.DoctorRepository;
import com.mftplus.patient.repository.SpecializationRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SpecializationService {

    private final SpecializationRepository specializationRepository;
    private final DoctorRepository doctorRepository;

    public SpecializationService(SpecializationRepository specializationRepository, DoctorRepository doctorRepository) {
        this.specializationRepository = specializationRepository;
        this.doctorRepository = doctorRepository;
    }


    @Transactional
    @CacheEvict(cacheNames = "specializations", allEntries = true)
    public Specialization save(Specialization specialization) {

        return specializationRepository.save(specialization);

    }

    @CacheEvict(cacheNames = "specializations", allEntries = true)
    public Specialization update(Specialization specialization) {
        Optional<Specialization> existingSpecialization = specializationRepository.findById(specialization.getId());
        if (existingSpecialization.isPresent()) {
            return specializationRepository.save(specialization);
        }
        throw new RuntimeException("Specialization not found with ID: " + specialization.getId());
    }

    public void delete(Long id) {
        specializationRepository.deleteById(id);
    }

    @CacheEvict(cacheNames = "specializations", allEntries = true)
    public List<Specialization> findAll() {
        return specializationRepository.findAll();
    }

    @CacheEvict(cacheNames = "specializations", allEntries = true)
    public Specialization findById(Long id) {
        return specializationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Specialization not found with ID: " + id));
    }

    @Transactional
    @CacheEvict(cacheNames = "specializations", allEntries = true)
    public Specialization findBySkillName(String skillName) {

        return specializationRepository.findBySkillName(skillName);
    }

    @Transactional
    @CacheEvict(cacheNames = "specializations", allEntries = true)
    public List<Specialization> findByDoctorNameAndSkillName(String doctorName, String skillName) {
        return specializationRepository.findByDoctorNameAndSkillName(doctorName, skillName);
    }


    @Transactional
    @CacheEvict(cacheNames = "specializations", allEntries = true)
    public List<Specialization> findByDoctorName(String doctorName) {
        return specializationRepository.findByDoctorName(doctorName);
    }

}
