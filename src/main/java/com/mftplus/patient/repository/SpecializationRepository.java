package com.mftplus.patient.repository;

import com.mftplus.patient.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
    @Query("select s from specializationEntity s where s.skillName = :skillName")
    Specialization findBySkillName(@Param("skillName") String skillName);

    @Query("select s from specializationEntity s cross join doctorEntity d where d.doctorName=:doctorName")
    List<Specialization> findByDoctorName(@Param("doctorName") String doctorName);

    @Query("select s from specializationEntity s cross join doctorEntity d where d.doctorName=:doctorName and s.skillName=:skillName")
    List<Specialization> findByDoctorNameAndSkillName(@Param("doctorName") String doctorName, @Param("skillName") String skillName);

}
