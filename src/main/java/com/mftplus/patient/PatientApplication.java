package com.mftplus.patient;

import com.mftplus.patient.model.Appointment;
import com.mftplus.patient.model.Patient;
import com.mftplus.patient.repository.AppointmentRepository;
import com.mftplus.patient.service.AppointmentServiceMicro;
import com.mftplus.patient.service.PatientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
//@Component
public class PatientApplication implements CommandLineRunner {
    private final PatientService patientService;
    private final AppointmentServiceMicro appointmentServiceMicro;


    public PatientApplication(PatientService patientService, AppointmentServiceMicro appointmentServiceMicro) {
        this.patientService = patientService;

        this.appointmentServiceMicro = appointmentServiceMicro;
    }


    public static void main(String[] args) {
        SpringApplication.run(PatientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Appointment appointment = Appointment.builder().startDateTime(LocalDateTime.now()).endDateTime(LocalDateTime.now().plusDays(2)).build();
//        appointmentServiceMicro.postAppointment(appointment);

        Patient patient = Patient.builder().firstName("mmm").lastName("xxx").deleted(false).build();
        patientService.save(patient);

    }
}
