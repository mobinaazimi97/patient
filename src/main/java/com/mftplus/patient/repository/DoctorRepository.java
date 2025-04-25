package com.mftplus.patient.repository;

import com.mftplus.patient.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query("select d from doctorEntity d where d.doctorName=:doctorName")
    List<Doctor> findByDoctorName(@Param("doctorName") String doctorName);

    @Query("select d from doctorEntity d join fetch d.specialization where d.specialization.skillName = :skillName")
    List<Doctor> findBySkillName(@Param("skillName") String skillName);

    @Query("SELECT d from doctorEntity d join fetch d.specialization where d.specialization.skillName=:skillName and d.doctorName=:doctorName")
    Doctor findByDoctorNameAndSpecialization(@Param("skillName") String skillName, @Param("doctorName") String doctorName);

}
