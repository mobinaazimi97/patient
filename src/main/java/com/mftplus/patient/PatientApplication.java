package com.mftplus.patient;

import com.mftplus.patient.model.Appointment;
import com.mftplus.patient.model.Patient;
import com.mftplus.patient.repository.AppointmentRepository;
import com.mftplus.patient.service.PatientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@SpringBootApplication
@Component
public class PatientApplication implements CommandLineRunner {
private final PatientService patientService;
    private final AppointmentRepository appointmentRepository;

    public PatientApplication(PatientService patientService, AppointmentRepository appointmentRepository) {
        this.patientService = patientService;
        this.appointmentRepository = appointmentRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(PatientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Patient patient= Patient.builder().firstName("mmm").lastName("xxx").deleted(false).build();
        Appointment appointment=Appointment.builder().patient(patient).startDateTime(LocalDateTime.now()).endDateTime(LocalDateTime.now().plusDays(2)).build();
        appointmentRepository.save(appointment);
    }
}
