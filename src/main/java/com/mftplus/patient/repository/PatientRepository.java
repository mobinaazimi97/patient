package com.mftplus.patient.repository;

import com.mftplus.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p from patientEntity p where p.lastName =:lastName")
    List<Patient> findByLastName(@Param("lastName") String lastName);

    @Query("select p from patientEntity p cross join appointmentEntity a where a.appointmentId=:appointmentId")
    List<Patient> findByAppointment(@Param("appointmentId") Long appointmentId);

    @Modifying
    @Query("update patientEntity p set p.deleted=true where p.patientId= :patientId")
    @Transactional
    void logicalRemove(@Param("patientId") Long patientId);

}
