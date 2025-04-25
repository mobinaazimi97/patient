package com.mftplus.patient.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mftplus.patient.controller.exception.NoContentException;
import com.mftplus.patient.model.Appointment;
import com.mftplus.patient.model.Patient;
import com.mftplus.patient.repository.AppointmentRepository;
import com.mftplus.patient.repository.PatientRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class PatientService {

    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;
    private final AppointmentServiceMicro appointmentServiceMicro;

    public PatientService(PatientRepository patientRepository, AppointmentRepository appointmentRepository, AppointmentServiceMicro appointmentServiceMicro) {
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
        this.appointmentServiceMicro = appointmentServiceMicro;
    }

    @PostConstruct
    public void init() {
        log.info("Cache init...");
        final List<Patient> patients = patientRepository.findAll();
        log.info("Cache initialized In PatientService...!!");
    }


    @Transactional
//    @CacheEvict(cacheNames = "patients", allEntries = true)
    public void save(Patient patient) throws JsonProcessingException, NoContentException {

        ResponseEntity<String> response=appointmentServiceMicro.postAppointment(patient.getAppointments().get(0));
        if (response.getStatusCode().equals(HttpStatus.OK)){
            ObjectMapper mapper=new ObjectMapper();

            Appointment appointment = mapper.readValue(response.getBody(), Appointment.class);
            appointmentRepository.save(appointment);
            patient.setAppointments(List.of(appointment));
            patientRepository.save(patient);
            System.out.println(mapper.writeValueAsString(appointment));

        }else {
            System.out.println("Error :" + response.getStatusCode() + " : " + response.getBody());
            throw new NoContentException();
        }

    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }
}
